package com.epam.dolanski.zadanie;

public class Main {

    public static void main(String[] args) {
        RecordManager recordManager = new RecordManager("src/main/resources/employee.csv");
        recordManager.readLines();
    }
}
