package com.epam.dolanski.suppress_warnings;

import java.util.ArrayList;

public class Ex1 {

    @SuppressWarnings("all")
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add("sonoo");
        list.add("vimal");
        list.add("ratan");

        for(Object obj:list)
            System.out.println(obj);

    }}
