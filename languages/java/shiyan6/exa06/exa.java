package shiyan6.exa06;

/**
 * 方法的重写-----为什么要进行方法的重写？
 * 方法的重写发生在子父类关系中。
 * 当父类提供的功能不满足子类具体的需求的时候，那么就需要对父类的方法进行重写。
 */
// 父类
class Animal {
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}

// 子类1：重写父类方法
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪！");
    }
}

// 子类2：重写父类方法
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵喵！");
    }
}

// 主类
public class exa {
    public static void main(String[] args) {
        // 创建对象
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        // 调用方法，展示重写效果
        System.out.println("动物声音：");
        animal.makeSound();

        System.out.println("\n狗的声音：");
        dog.makeSound();

        System.out.println("\n猫的声音：");
        cat.makeSound();

        // 多态演示：父类引用指向子类对象
        System.out.println("\n=== 多态演示 ===");
        Animal myPet1 = new Dog();
        Animal myPet2 = new Cat();

        myPet1.makeSound(); // 输出：汪汪汪！
        myPet2.makeSound(); // 输出：喵喵喵！
    }
}