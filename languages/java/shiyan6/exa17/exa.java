package shiyan6.exa17;

import shiyan6.exa03.Animal;

/**
 * 匿名内部类的前提：必须是类或者接口
 * 格式：
 * new 类名/接口名(){ //子类或接口的实现类
 * 重写抽象方法
 * }
 * 用途：作为方法的参数传递（前提是类或接口只有一个方法的时候），
 * 多个方法时，建议建立一个类实现接口或继承父类的形式。
 * 传统实现方式:
 * 1.编写实现类
 * 2.重写抽象方法
 * 3.创建实现类对象
 * 4.将实现类对象作为方法的参数传递
 */
public class exa {
    public static void main(String[] args) {
        /*
         * 传统的方式必须是子类重写，创建子类对象调用方法
         * Dog d = new Dog();
         * d.eat();
         */
        useAnimal(new Animal() {
            public void eat() {
                System.out.println("狗吃骨头----！");
            }
        });
        // 调用方式一
        // 整体就等效于：是 Animal 父类的子类对象
        new Animal() {
            @Override
            public void eat() {
                System.out.println("狗吃肉---");
            }
        }.eat();
        // 调用方式二
        // 通过匿名内部类访问局部变量。在 JDK8 版本之前，必须加 final 关键字
        String name = "哈士奇";
        // name = "金毛";//不能赋值
        Animal a = new Animal() {
            @Override
            public void eat() {
                System.out.println(name + "狗吃肉---");
            }
        };
        a.eat();
    }

    public static void useAnimal(Animal a) {
        a.eat();
    }
}
