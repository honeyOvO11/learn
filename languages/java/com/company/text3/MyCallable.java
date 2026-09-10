package com.company.text3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程表白第：" + (i + 1) + "次");
        }
        return "答应了!!!";
    }
}
