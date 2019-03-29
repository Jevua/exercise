package com.example.exercise.cloneable;

public class CloneableDemo implements Cloneable{
    private String name;

    @Override
    public Object clone() {
        try {
            CloneableDemo cloneableDemo = (CloneableDemo) super.clone();
            return cloneableDemo;
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CloneableDemo cloneableDemo = new CloneableDemo();
        cloneableDemo.name = "sss";
        CloneableDemo clone = (CloneableDemo) cloneableDemo.clone();
        System.out.println(clone.name);
        System.out.println(cloneableDemo);
        System.out.println(clone);
    }
}
