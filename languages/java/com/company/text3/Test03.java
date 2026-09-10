package com.company.text3;

import java.util.concurrent.*;

public class Test03 {
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft); // FutureTask 是 Runnable 实现类
        thread.start();
        // 用于获取执行结果，该方法会发生阻塞，一直等到任务执行完毕才返回执行结果
        String s = ft.get();
        System.out.println(s);
    }
}
