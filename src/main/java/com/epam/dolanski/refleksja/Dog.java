package com.epam.dolanski.refleksja;

import jdk.jfr.DataAmount;

class Dog {

    boolean letHimBark = true;

    public String squeak() {
        return "piiiii";
    }

    String howls() {
        return "wuuuuoooo";
    }

    private String bark() {
        return "hau";
    }

    private class Chihuahua {

        private Integer legs = 4;
        private Long speed = 20L;
        private final Double height;

        @DogName(name = "chihuahua")
        @DogColour(colour = "blue")
        public Chihuahua(Integer legs, Long speed) {
            this.legs = legs;
            this.speed = speed;
            height = 26.4;
            int something = 1;
        }

        public Chihuahua() {
            height = 0.0;
        }

        @Deprecated
        private void chain(Dog dog) {
            dog.letHimBark = false;
        }


        @DataAmount
        private void runFaster() {
            speed++;
        }

    }
}
