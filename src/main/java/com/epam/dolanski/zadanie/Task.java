package com.epam.dolanski.zadanie;

public record Task(Integer id, String description, Project project, Employee owner) {
}
