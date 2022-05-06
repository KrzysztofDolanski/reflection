package com.epam.dolanski;

import com.epam.dolanski.create_annotation.Anno;
import com.epam.dolanski.create_annotation.SampleClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class SampleClassTest {


    @Test
    void annotationShouldHaveProperName() throws NoSuchMethodException {
        SampleClass sampleClass = new SampleClass();
        // Given
        Method method = sampleClass.getClass().getMethod("sampleMethod");
        // When
        Anno annotation = method.getAnnotation(Anno.class);
        // Then
        System.err.println(annotation.value());
        assertEquals(annotation.value(), 10);
    }

}
