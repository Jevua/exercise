package com.example.exercise.Jdk8.InterfaceDemo;

public class InterfaceImpl implements Interface {


    @Override
    public void functionnalInterface() {
        System.out.println("接口中只有一个抽象方法的是函数式接口，可以使用注解@FunctionalInterface进行检查");
    }

    public static void main(String[] args) {

    }
}
