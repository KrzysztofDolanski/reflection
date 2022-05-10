package com.epam.dolanski;

import com.epam.dolanski.create_annotation.Anno;
import com.epam.dolanski.create_annotation.SampleClass;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SampleClassTest {

    SampleClass sampleClass = new SampleClass();

    @Test
    void annotationShouldHaveNameAnno() {
        // Given
        Method[] declaredMethods = sampleClass.getClass().getDeclaredMethods();
        // When
        Annotation annotation = Arrays.stream(Arrays.stream(declaredMethods).findFirst().orElseThrow().getDeclaredAnnotations()).findFirst().orElseThrow();
        // Then
        assertTrue(annotation.toString().contains("Anno"));
    }

    @Test
    void annotationShouldHaveValueEquals10() throws NoSuchMethodException {
        // Given
        Method method = sampleClass.getClass().getMethod("sampleMethod");
        // When
        var annotation = method.getAnnotation(Anno.class);
        // Then
        System.err.println(annotation.value());
        assertEquals(annotation.value(), 10);
    }

}
