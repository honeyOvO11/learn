package shiyan6.exa04;

/*
* 静态方法可以直接通过类名来调用
* 静态属于类。随着类的加载而加载。
* 非静态属于对象。随着对象的创建而加载。
* 静态和非静态的访问特点：
* 1.静态的只能访问静态的
* 2.非静态的既可以访问静态的。也可以访问非静态的。
* 3.静态方法多在工具类中。
*/
public class shiyan1 {
    // 静态方法 - 可以直接通过类名调用
    public static void printMessage() {
        System.out.println("这是一个静态方法，无需创建对象即可调用");
    }

    // 实例方法 - 需要创建对象后才能调用
    public void printInstanceMessage() {
        System.out.println("这是一个实例方法，需要创建对象后才能调用");
    }

    // 另一个静态方法，演示静态方法之间的调用
    public static void callAnotherStatic() {
        System.out.println("这个静态方法调用了另一个静态方法:");
        printMessage(); // 静态方法可以直接调用其他静态方法
    }

    public static void main(String[] args) {
        // 直接通过类名调用静态方法，无需创建对象
        shiyan1.printMessage();
        System.out.println();

        // 调用另一个静态方法
        shiyan1.callAnotherStatic();
        System.out.println();

        // 实例方法需要创建对象后才能调用
        shiyan1 obj = new shiyan1();
        obj.printInstanceMessage();
    }
}