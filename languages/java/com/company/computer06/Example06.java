package com.company.computer06;

public class Example06 {
    public static void main(String[] args) {
        try {
            System.out.println(divide(-4, 2));
        } catch (DivideByMinusException e) {
            System.out.println(e.toString());
        }
        System.out.println("程序会继续执行下去-------！！！");
    }

    public static int divide(int x, int y) throws DivideByMinusException {
        if (x < 0)
            throw new DivideByMinusException("被除数是负数的异常---！");
        else {
            int result = x / y;
            return result;
        }
    }
}
