package com.example.exercise.outerandinner;

/**
 * @author xzh
 */
public class OuterDemo {

    // 实现单例模式，需要私有化构造方法
    private static class GetClass {
        private static final OuterDemo instance = new OuterDemo();
    }
    public static OuterDemo getInstance() {
        return GetClass.instance;
    }

    private OuterDemo() {

    }

    private int num = 30;

    class Inner {
        private int num = 20;
        public void show(){
            int num = 10;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(OuterDemo.this.num);
        }
    }

    static class StaticClass {
        public static void test() {
            System.out.println("hello world!");
        }
    }

    public static void main(String[] args) {
        OuterDemo.Inner inner = new OuterDemo().new Inner();
        inner.show();
        OuterDemo.StaticClass.test();
    }
}
