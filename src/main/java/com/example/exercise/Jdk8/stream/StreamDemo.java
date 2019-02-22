package com.example.exercise.Jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        IntStream.of(new int[] {1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3)//1、2、3
                .forEach(System.out::println);

        List<String> list = Arrays.asList("java", "scala", "python", "shell", "ruby");
        long num = list.parallelStream()//并行流
                .filter(x -> x.length() < 5)//过滤长度小于5的
                .count();//计数
        System.out.println(num);

        Map map = list.parallelStream().collect(Collectors.toMap(l -> l, l -> l));
        System.out.println(map);

        String join = list.parallelStream().collect(Collectors.joining(" , "));
        System.out.println(join);


        list.stream()//串行流
                .filter(s -> s.startsWith(s))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        LongStream.rangeClosed( 0,110 )
                //并行流
                .parallel()
                .reduce( 0,Long::sum );


        LongStream.rangeClosed( 0,110 )
                //顺序流
                .sequential()
                .reduce( 0,Long::sum );

    }
}
