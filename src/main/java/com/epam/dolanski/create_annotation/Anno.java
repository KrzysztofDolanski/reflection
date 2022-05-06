package com.epam.dolanski.create_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public @interface Anno {

    int value() default 10;
}
