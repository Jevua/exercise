package com.example.exercise.Jdk8.InterfaceDemo;

public interface Interface {
    //可以被实现类覆盖
    default void sout() {
        System.out.println("default function");
    }

    static void other() {
        System.out.println("static function");
    }

    public static void main(String[] args) {
        //匿名接口实现
        Interface test = new Interface() {
            @Override
            public void sout() {
                System.out.println("实现类sout");
            }
        };
        InterfaceImpl in = new InterfaceImpl();
        in.sout();
        //实现类可以直接调用接口default方法
        test.sout();
        //接口可以直接调用自身的static方法
        Interface.other();
    }
}
