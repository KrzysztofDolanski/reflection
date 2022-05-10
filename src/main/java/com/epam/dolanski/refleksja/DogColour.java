package com.epam.dolanski.refleksja;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
public @interface DogColour {

    String colour();
}
