package com.epam.dolanski;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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

    public String[] getFieldsFromConstructor(){
        return new String[1];
    }
}
