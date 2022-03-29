package com.epam.dolanski;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;

public class MainTest {
    
    
    @Test
    void shouldReturnBark() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    // Given
        AnimalsReflection animalsReflection = new AnimalsReflection();
    // When
        String bark = animalsReflection.barkFromDog();
    // Then
        assertEquals(bark, "hau");
    }


}
