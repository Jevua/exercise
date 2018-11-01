package com.example.exercise.Jdk8.InterfaceDemo;

@FunctionalInterface
public interface Interface {
    //可以被实现类覆盖——默认方法
    default void sout() {
        System.out.println("default function");
    }

    //静态方法
    static void other() {
        System.out.println("static function");
    }

    /**
     * 普通的抽象方法
     */
    void functionnalInterface();

    @Override
    String toString();

    public static void main(String[] args) {
        //匿名接口实现
        Interface intf = new Interface() {
            @Override
            public void functionnalInterface() {
                System.out.println("匿名实现");
            }
        };
        intf.functionnalInterface();

        //lambda实现——函数式接口
        Interface intfLambda = () -> System.out.println("lambda实现");

        intfLambda.functionnalInterface();

        Interface test = new InterfaceImpl();
        InterfaceImpl in = new InterfaceImpl();
        in.sout();
        //实现类可以直接调用接口default方法
        test.sout();
        //接口可以直接调用自身的static方法
        Interface.other();
    }
}
