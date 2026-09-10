package shiyan6.exa13;

/**
 * 1.多态的转型
 * 向上转型：父类引用指向子类对象
 * 向下转型：由父类引用转成一个对应的真实的子类对象
 * 格式：目标对象类型 对象名 = （目标对象类型）被转换的引用
 * 2.注意事项：
 * 一定要确保转换的类型相同。否则会发类型转换异常：ClassCatException
 * 3.关键字：
 * instanceof 用于判断左边的引用是否是右边的对象类型
 */
// 父类
class Animal {
    public void eat() {
        System.out.println("动物吃东西");
    }
}

// 子类
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    // 狗特有的方法
    public void bark() {
        System.out.println("汪汪叫");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    // 猫特有的方法
    public void meow() {
        System.out.println("喵喵叫");
    }
}

public class exa {
    public static void main(String[] args) {
        // 1. 向上转型 - 多态
        Animal animal1 = new Dog(); // 子类转父类
        Animal animal2 = new Cat(); // 子类转父类

        System.out.println("=== 多态演示 ===");
        animal1.eat(); // 输出：狗吃骨头
        animal2.eat(); // 输出：猫吃鱼

        // 2. instanceof 使用
        System.out.println("\n=== instanceof 演示 ===");
        System.out.println("animal1 是 Dog: " + (animal1 instanceof Dog)); // true
        System.out.println("animal1 是 Cat: " + (animal1 instanceof Cat)); // false
        System.out.println("animal1 是 Animal: " + (animal1 instanceof Animal)); // true

        // 3. 向下转型
        System.out.println("\n=== 向下转型演示 ===");
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1; // 父类转子类
            dog.bark(); // 调用狗特有的方法
        }

        if (animal2 instanceof Cat) {
            Cat cat = (Cat) animal2; // 父类转子类
            cat.meow(); // 调用猫特有的方法
        }

        // 4. 错误的转型示例
        System.out.println("\n=== 错误转型处理 ===");
        Animal animal = new Dog();

        // 错误方式：直接转型会报错
        // Cat wrongCat = (Cat) animal; // 运行时报错：ClassCastException

        // 正确方式：先用instanceof检查
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.meow();
        } else {
            System.out.println("不能将动物转换为猫");
        }

        // 5. 数组中的多态
        System.out.println("\n=== 数组多态演示 ===");
        Animal[] animals = { new Dog(), new Cat(), new Dog() };

        for (Animal a : animals) {
            a.eat(); // 多态调用

            if (a instanceof Dog) {
                ((Dog) a).bark(); // 直接转型调用
            } else if (a instanceof Cat) {
                ((Cat) a).meow(); // 直接转型调用
            }
        }
    }
}