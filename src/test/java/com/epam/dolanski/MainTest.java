package com.epam.dolanski;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MainTest {


    AnimalsReflection animalsReflection;

    @BeforeMethod
    void setup() {
        animalsReflection = new AnimalsReflection();
    }

    @Test
    void shouldReturnBark() {
        // Given
        // When
        String bark = animalsReflection.barkFromDog();
        // Then
        assertEquals(bark, "hau");
    }

    @Test
    void shouldReturnClassName() throws ClassNotFoundException {
        // Given
        // When
        String innerClassChihuahua = animalsReflection.getDogInnerClassName();
        // Then
        assertEquals(innerClassChihuahua, "Chihuahua");
    }

    @Test
    void shouldReturnNameOfFieldsInDogInnerClass() {
        // Given
        String[] expected = {"legs", "speed", "height"};
        // When
        String[] names = animalsReflection.getNamesOfFields();
        // Then
        assertEquals(names, expected);
    }

    @Test
    void shouldReturnNameOfFieldsInConstructorOfInnerClass() {
        List<String> expected = List.of("Dog",
                "Integer",
                "Long"
        );
        List<String> parametersOfmConstructor = animalsReflection.getParametersOfConstructor();
        assertEquals(parametersOfmConstructor, expected);
    }

    @Test
    void shouldShowAnnotation() {
        // Given
        List<String> expected = List.of("Deprecated", "DataAmount");
        // When
        List<String> annotations = animalsReflection.getAnnotations();
        // Then
        assertEquals(annotations, expected);
    }
}
