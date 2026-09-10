package com.company.text1;

public class Test01 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
