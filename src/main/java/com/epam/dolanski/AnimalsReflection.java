package com.epam.dolanski;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalsReflection {

    public String barkFromDog() {
        Dog dog = new Dog();
        String result = "";
        Method bark = null;
        try {
            bark = Dog.class.getDeclaredMethod("bark");
        } catch (NoSuchMethodException e) {
            System.err.println(e.getMessage());
        }
        try {
            bark.setAccessible(true);
            result += (String) bark.invoke(dog);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public String getDogInnerClassName() {
        Class<?> classDog = Dog.class.getDeclaredClasses()[0];
        Constructor<?> dogConstructor = classDog.getDeclaredConstructors()[0];
        return Arrays.stream(dogConstructor.getDeclaringClass().getCanonicalName().split("\\.")).reduce((a, b) -> b).orElseThrow();
    }

    public String[] getNamesOfFields() {
        Class<?>[] declaredClasses = Dog.class.getDeclaredClasses();
        int length = declaredClasses[0].getDeclaredFields().length - 1;
        String[] fieldsNames = new String[length];
        for (int i = 0; i < length; i++) {
            fieldsNames[i] = declaredClasses[0].getDeclaredFields()[i].getName();
        }
        return fieldsNames;
    }

    public List<String> getParametersOfConstructor() {
        List<String> result = new ArrayList<>();
        Constructor<?> declaredConstructor = Dog.class.getDeclaredClasses()[0].getDeclaredConstructors()[0];
        for (Parameter parameter : declaredConstructor.getParameters()) {
            result.add(parameter.getType().getSimpleName());
        }
        return result;
    }


    @Deprecated
    public List<String> getAnnotations() {
        List<String> result = new ArrayList<>();
        for (Class<?> declaredClass : Dog.class.getDeclaredClasses()) {
            for (Method declaredMethod : declaredClass.getDeclaredMethods()) {
                for (Annotation annotation : declaredMethod.getAnnotations()) {
                    result.add(annotation.annotationType().getSimpleName());
                }
            }
        }
        return result;
    }

    //todo This is not working. Get to inner class is not so simple.
    public Object getConstructor() {
        Constructor<?> constructor;

        Object instanceChihuahua = null;
        Class<?>[] declaredClasses = Dog.class.getDeclaredClasses();
       for (Class<?> declaredClass : declaredClasses) {
            try {
                constructor = declaredClass.getClassLoader().loadClass("Chihuahua").getConstructor();
                instanceChihuahua = constructor.newInstance();
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
       }
        return instanceChihuahua;
    }

}
