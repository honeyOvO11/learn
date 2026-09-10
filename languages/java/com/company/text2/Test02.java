package com.company.text2;

public class Test02 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
