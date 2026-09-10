package shiyan6.exa12;

/*
* 多态
* 1.什么是多态
* 指的是事物的多种表现形态。
* 例如：猫是一只动物。猫是一只猫
* 2.多态的前提条件
* 要有继承或者实现的关系
* 要有方法重写
* 要有父类引用指向子类的对象
* 3.多态的成员访问特点
* 成员变量：编译看父类、运行看父类。
* 成员方法：编译看父类、运行看子类。
* 4.多态的好处和弊端
* 好处：提高代码扩展性和维护性
* 弊端：无法使用子类特有的成员
* 5.多态的使用场景
* 可以作为方法的参数和返回值进行使用。
* 可以提高代码的扩展性。
*/
// 父类
class Animal {
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}

// 子类1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪！");
    }
}

// 子类2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵！");
    }
}

// 主程序
public class exa {
    public static void main(String[] args) {
        System.out.println("=== 多态演示 ===\n");

        // 多态：父类引用指向子类对象
        Animal animal1 = new Dog(); // 向上转型
        Animal animal2 = new Cat(); // 向上转型

        // 同样的方法调用，产生不同的行为
        System.out.println("动物1的叫声：");
        animal1.makeSound();

        System.out.println("\n动物2的叫声：");
        animal2.makeSound();

        // 使用数组演示多态
        System.out.println("\n=== 数组多态演示 ===");
        Animal[] animals = { new Dog(), new Cat(), new Dog() };

        for (Animal animal : animals) {
            animal.makeSound(); // 运行时确定调用哪个方法
        }

        // 方法参数多态
        System.out.println("\n=== 方法参数多态 ===");
        playWithAnimal(new Dog());
        playWithAnimal(new Cat());
    }

    // 方法参数使用父类类型，可以接受任何子类对象
    public static void playWithAnimal(Animal animal) {
        System.out.print("和动物玩耍，它说：");
        animal.makeSound();
    }
}