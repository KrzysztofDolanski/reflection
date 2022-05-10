package com.epam.dolanski.zadanie;

public class Records {


    record Task(Integer id, String description, Project project, Employee owner) implements Data {
    }

    record Project(Integer id, String name) implements Data {
    }

    record Employee(Integer id, String firstName, String lastName, String position) implements Data {
    }
}
