package shiyan6.exa09;

/**
 * final 关键字作用：
 * final 修饰类：类变成了一个最终的类，不能有任何的子类
 * final 修饰方法：方法变成了一个最终的方法，不能重写
 * final 修饰变量：变量就变成了一个常量，只能赋值一次
 */
// 1. final类：无法被继承
final class FinalClass {
    public void show() {
        System.out.println("FinalClass不能被继承");
    }
}

// 2. final方法：无法被重写
class Parent {
    public final void finalMethod() {
        System.out.println("父类的final方法，不能被子类重写");
    }
}

class Child extends Parent {
    // 尝试重写finalMethod()会导致编译错误
    // public void finalMethod() { }
}

public class FinalDemo {
    // 3. final变量：常量（必须初始化，不可修改）
    private final int finalVar = 100;
    private static final String CONSTANT = "全局常量";

    public void demonstrateFinal() {
        // final局部变量
        final double localFinal = 3.14;

        // 以下修改会编译错误：
        // finalVar = 200;
        // localFinal = 2.71;

        System.out.println("实例常量: " + finalVar);
        System.out.println("静态常量: " + CONSTANT);
        System.out.println("局部常量: " + localFinal);
    }

    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo();
        demo.demonstrateFinal();

        // final参数示例
        demo.finalParameter("不可变参数");

        new Child().finalMethod(); // 调用继承的final方法
        new FinalClass().show(); // 使用final类
    }

    // 4. final参数：方法内部不能修改参数值
    public void finalParameter(final String msg) {
        // msg = "修改"; // 编译错误
        System.out.println("final参数: " + msg);
    }
}