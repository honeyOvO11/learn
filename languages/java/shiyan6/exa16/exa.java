package shiyan6.exa16;

/**
 * 静态成员内部类：
 * 静态内部类只能访问外部类的静态成员
 * 创建对象格式：
 * 外部类名.内部类名 对象名 = new Outer.Inner();
 * 外部类名.内部类名 对象名 = new Outer().new Inner();(普通成员内部类)
 */
public class exa {

    // 外部类
    static class University {
        static String name = "清华大学";

        // 静态内部类
        static class College {
            String collegeName;

            College(String name) {
                this.collegeName = name;
            }

            void showInfo() {
                System.out.println(collegeName + "学院 - " + University.name);
            }

            static void universityInfo() {
                System.out.println("大学名称: " + name);
            }
        }
    }

    public static void main(String[] args) {
        // 直接创建静态内部类，不需要外部类实例
        University.College college1 = new University.College("计算机");
        University.College college2 = new University.College("物理");

        college1.showInfo();
        college2.showInfo();

        // 调用静态内部类的静态方法
        University.College.universityInfo();

        // 另一个例子：计算器
        Calculator.Operation add = new Calculator.Operation("加法");
        add.execute(5, 3);

        Calculator.Operation.multiply(4, 6);
    }
}

// 计算器类
class Calculator {
    // 静态内部类：操作
    static class Operation {
        String name;

        Operation(String name) {
            this.name = name;
        }

        void execute(int a, int b) {
            System.out.println(name + ": " + a + " + " + b + " = " + (a + b));
        }

        static void multiply(int a, int b) {
            System.out.println("乘法: " + a + " × " + b + " = " + (a * b));
        }
    }
}