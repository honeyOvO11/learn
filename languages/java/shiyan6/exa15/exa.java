package shiyan6.exa15;

/**
 * 局部内部类可以访问外部类所有成员，而在外部类中无法直接访问局部内部类中的成员
 * 如何访问局部内部类？
 * 只需创建外部类对象。调用所属方法即可。
 */
public class exa {

    public static void main(String[] args) {
        // 直接在main方法中使用局部内部类
        class Greeter {
            public void greet(String name) {
                System.out.println("你好, " + name);
            }
        }

        Greeter greeter = new Greeter();
        greeter.greet("张三");
        greeter.greet("李四");

        // 另一个例子
        testLocalClass();
    }

    static void testLocalClass() {
        final int base = 10;

        class Adder {
            public void add(int x) {
                System.out.println(base + " + " + x + " = " + (base + x));
            }
        }

        Adder adder = new Adder();
        adder.add(5);
        adder.add(8);
    }
}