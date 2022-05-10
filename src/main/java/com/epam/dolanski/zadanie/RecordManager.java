package com.epam.dolanski.zadanie;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class RecordManager {
    List<String> csvList = new ArrayList<>();
    private static final Map<Class<Data>, Map<Integer, Data>> dataMap = new HashMap<>();
    private String path;

    public RecordManager(String path) {
        this.path = path;
    }

    void readLines() {
        String[] filePath = path.split("/");
        String[] fileName = filePath[filePath.length - 1].split("\\.");
        String fileNameWithoutType = fileName[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            Records record = new Records();
            breakPoint:
            for (Class<?> declaredClass : record.getClass().getNestMembers()) {
                if (declaredClass.getSimpleName().toLowerCase(Locale.ROOT).contains(fileNameWithoutType)) {
                    while ((nextRecord = csvReader.readNext()) != null) {

                        for (Constructor<?> declaredConstructor : declaredClass.getDeclaredConstructors()) {
                            @SuppressWarnings("all")
                            Queue queue = new LinkedList();
                            for (Class<?> parameterType : declaredConstructor.getParameterTypes()) {
                                queue.add(parameterType);
                            }

                            String[] entity = nextRecord;

                            Data newInstance = null;
                            switch (declaredClass.getSimpleName()) {
                                case "Task" -> {
                                    newInstance = (Records.Task) declaredConstructor.newInstance(
                                            Integer.parseInt(entity[0]),
                                            entity[1],
                                            entity[2],
                                            Integer.parseInt(entity[3])
                                    );
                                    addToMap(Records.Task.class, newInstance, Integer.parseInt(entity[0]));
                                }
                                case "Project" -> {
                                    newInstance = (Records.Project) declaredConstructor.newInstance(
                                            Integer.parseInt(entity[0]),
                                            entity[1]
                                    );
                                    addToMap(Records.Project.class, newInstance, Integer.parseInt(entity[0]));
                                }
                                case "Employee" -> {
                                    newInstance = (Records.Employee) declaredConstructor.newInstance(
                                            Integer.parseInt(entity[0]),
                                            entity[1],
                                            entity[2],
                                            entity[3]);
                                    addToMap(Records.Employee.class, newInstance, Integer.parseInt(entity[0]));
                                }
                                default -> System.err.println(new ClassNotFoundException().getMessage());
                            }

                            System.out.println(newInstance);

                        }

                    }
                    break breakPoint;
                }
            }
        } catch (IOException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchFieldException e) {
            System.err.println(e.getMessage());
        }
    }

    public Data find(Data recordClass, Integer id) {
        return dataMap.get(recordClass).get(id);
    }

    public List<Data> list(Class<Data> recordClass) {
        Map<Integer, Data> integerDataMap = dataMap.get(recordClass);
        return new ArrayList<>(integerDataMap.values());
    }

    private void addToMap(Class<? extends Data> recordClass, Data entity, Integer id) throws NoSuchFieldException, IllegalAccessException {
        if (dataMap.containsKey(recordClass)) {
            Map<Integer, Data> integerDataMap = dataMap.get(recordClass);

            integerDataMap.put(id, entity);
            dataMap.put((Class<Data>) recordClass, integerDataMap);
        } else {
            Map<Integer, Data> map = new HashMap<>();
            map.put(id, entity);
            dataMap.put((Class<Data>) recordClass, map);
        }
    }
}
