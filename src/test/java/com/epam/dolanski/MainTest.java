package com.epam.dolanski;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

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
        List<String> expected = List.of("Dog", "Integer", "Long");
        expected.stream().collect(Collectors.partitioningBy(x->expected.indexOf(x)%3==0)).values();
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

    private Class<?> animal;

    @BeforeGroups
    public void setup2(){
        try {
            animal = Class.forName("com.epam.dolanski.Animal");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + "Class don't exists");
        }
    }

    @Test
    void animalClassShouldNotExist(){
        assertNotNull(animal);
    }
}
