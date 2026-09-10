package com.company.computer06;

/**
 * 自定义的异常类只需继承Exception类，在构造方法中使用super()语句调用Exception
 * 的构造方法即可。
 **/
public class DivideByMinusException extends Exception {
    public DivideByMinusException() {
        super();
    }

    public DivideByMinusException(String message) {
        super(message);
    }
}