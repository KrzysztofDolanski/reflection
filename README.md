# Reflection in java  ![java reflection](src/main/resources/img.png)

## Table of contents


* [Overview](#overview)
* [Purpose of reflection](#Purpose of reflection)
* [Classes](#classes)
* [Methods](#methods)
* [Constructors](#constructors)
* [Fields](#fields)
* [Usages](#usages)



## Overview
```
The reflection classes, such as Method, are found in java.lang.reflect. 
There are three steps that must be followed to use these classes. 
The first step is to obtain a java.lang.Class object for the class that 
you want to manipulate. java.lang.Class is used to represent classes and interfaces 
in a running Java program.
```
<i>Package java.lang.reflect

<q>Classes

| [AccessibleObject](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/AccessibleObject.html) |    [Array](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Array.html)    | [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html) | [Executable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Executable.html) |[Field](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html) |
|-------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------:|--------------------------------------------------------------------------------------------------------:|
| [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)                     | [Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html) |   [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)   |      [Proxy](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html)      | [ReflectPermission](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/ReflectPermission.html) |



## Purpose of reflection
How do you test a class that doesn't exist?



## Classes



## Methods




## Constructors




## Fields




## Usages



# Annotations
````````
Annotations, a form of metadata, provide data about a program that is not part of the program itself. 
Annotations have no direct effect on the operation of the code they annotate.
Annotations have a number of uses, among them:

    Information for the compiler — Annotations can be used by the compiler to detect errors or suppress warnings.
    Compile-time and deployment-time processing — Software tools can process annotation information to generate code, XML files, and so forth.
    Runtime processing — Some annotations are available to be examined at runtime.

This lesson explains where annotations can be used, how to apply annotations, what predefined annotation types 
are available in the Java Platform, Standard Edition (Java SE API), how type annotations can be used in conjunction with 
pluggable type systems to write code with stronger type checking, and how to implement repeating annotations.
````````
## Predefined Annotation Types
A set of annotation types are predefined in the Java SE API. Some annotation types are used by the Java compiler, and some apply to other annotations.
Annotations can be applied to declarations: declarations of classes, fields, methods, and other program elements.
Some annotation types are used by the Java compiler, and some apply to other annotations.

@Deprecated
@Override
@SuppressWarnings

