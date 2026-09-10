package shiyan6.exa05;

/**
 * 继承：
 * 1.什么是继承？
 * 说白了就是让类与类之间产生了关系。子父类的关系
 * 2.继承的关键字。
 * 子类 extends 父类
 * 3.java 中的继承的特点。
 * 只支持单继承。但是可以多层继承。
 * 4.继承父类只能使用父类的公共成员。
 * 5.继承的好处和弊端。
 * 好处：提高了代码的复用性。提高代码的维护性。
 * 弊端：类与类之间的耦合性太强。
 */
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String speak() {
        return "动物叫";
    }
} // 父类：动物

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public String speak() {
        return name + "汪汪叫";
    }
}

public class exa {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财");
        System.out.println(dog.speak());
    }
}
