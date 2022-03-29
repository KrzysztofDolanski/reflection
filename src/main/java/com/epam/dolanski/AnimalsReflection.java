package com.epam.dolanski;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public String getInnerClassChihuahua() throws ClassNotFoundException {
       return "";
    }
}
