package com.epam.dolanski;

class Dog {


    public String squeak(){
        return "piiiii";
    }

    String howls(){
        return "wuuuuoooo";
    }

    private String bark(){
        return "hau";
    }

    private class Chihuahua{

        public Chihuahua(Integer legs, Long speed) {
            this.legs = legs;
            this.speed = speed;
            height = 26.4;;
        }

        private Integer legs = 4;
        private Long speed  = 20L;
        private final Double height;
    }
}
