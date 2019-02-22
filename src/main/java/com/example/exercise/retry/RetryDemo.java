package com.example.exercise.retry;

public class RetryDemo {
    public static void main(String[] args) {
        //大致理解了，retry标志符只会用在循环标记词的前面，比如：for while等，标记这个循环
        //只会跟在break和continue后面
        // break的意思是跳出retryy标记的这个循环。contine是跳过标记的循环，重新进入
            int i = 0;
            retry:  //①
            while (true) {
                i++;
                System.out.println("i=" + i);
                int j = 0;
//            retry:   //②
                for (; ; ) {
                    j++;
                    System.out.println("j=" + j);
                    if (j == 2) {
                        break retry;
                    }
                }
            }
    }
}
