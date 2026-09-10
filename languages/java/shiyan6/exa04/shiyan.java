package shiyan6.exa04;

/*
* static 关键字：
* 修饰变量，变量可以被所有的对象所共享。
* 什么时候将变量定义成静态的呢？
* 1.当一个变量需要被类中的所有对象所共享的时候。
* 2.可以通过 类名.静态变量 访问静态变量。
* 3.只能修饰成员变量。
*/
public class shiyan {
    static int counter = 0;
    int id;

    public shiyan() {
        counter++;
        id = counter;
    }

    public static void main(String[] args) {
        System.out.println("初始计数器" + shiyan.counter);
        shiyan a1 = new shiyan();
        shiyan a2 = new shiyan();
        shiyan a3 = new shiyan();
        System.out.println("创建三个对象后：");
        System.out.println("静态计数器" + shiyan.counter);
        System.out.println("a1的id：" + a1.id);
        System.out.println("a2的id：" + a2.id);
        System.out.println("a3的id：" + a3.id);
    }
}
