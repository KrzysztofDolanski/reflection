package com.epam.dolanski;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;

public class MainTest {
    
    
    @Test
    void shouldReturnBark(){
    // Given
        AnimalsReflection animalsReflection = new AnimalsReflection();
    // When
        String bark = animalsReflection.barkFromDog();
    // Then
        assertEquals(bark, "hau");
    }

    @Test
    void shouldReturnClassName() throws ClassNotFoundException {
    // Given
        AnimalsReflection animalsReflection = new AnimalsReflection();
    // When
        String innerClassChihuahua = animalsReflection.getInnerClassChihuahua();
        // Then
        assertEquals(innerClassChihuahua, "Chihuahua");
    }

}
