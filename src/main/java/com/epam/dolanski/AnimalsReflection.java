package com.epam.dolanski;

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
            e.printStackTrace();
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
}
