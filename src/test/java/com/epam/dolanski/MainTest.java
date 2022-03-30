package com.epam.dolanski;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest {


    @Test
    void shouldReturnBark() {
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
        String innerClassChihuahua = animalsReflection.getDogInnerClassName();
        // Then
        assertEquals(innerClassChihuahua, "Chihuahua");
    }

    @Test
    void shouldReturnNameOfFieldsInDogInnerClass() {
        // Given
        AnimalsReflection animalsReflection = new AnimalsReflection();
        // When
        String[] expected = {"legs", "speed", "height"};
        String[] names = animalsReflection.getNamesOfFields();
        // Then
        assertEquals(names, expected);
    }

    @Test
    void shouldReturnComeOfFieldsInConstructorOfInnerClass(){

    }
}
