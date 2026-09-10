package shiyan6.exa11;

/**
 * 接口：
 * 1.什么是接口
 * 接口是一种更加抽象的类。它完成的是一种特性的功能。
 * 接口的出现，打破了单继承的局限性。
 * 2.接口如何定义及成员特点
 * public interface 接口名{
 * //常量
 * //抽象方法
 * //默认方法
 * //静态方法
 * }
 * 3.接口的注意事项
 * 接口不能有构造方法
 * 接口不能直接创建对象使用的
 * 4.接口与类之间的关系
 * 实现关系：implements 而且可以多实现
 * 5.接口和接口之间的关系
 * 继承的关系：extends 接口可以多继承
 */
interface Vehicle {
    void start(); // 抽象方法

    void stop(); // 抽象方法
}

// 实现接口的类1
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("汽车启动：踩油门");
    }

    @Override
    public void stop() {
        System.out.println("汽车停止：踩刹车");
    }
}

// 实现接口的类2
class Bicycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("自行车启动：开始蹬踏板");
    }

    @Override
    public void stop() {
        System.out.println("自行车停止：捏刹车");
    }
}

// 主程序
public class exa {
    public static void main(String[] args) {
        System.out.println("=== 简单的接口示例 ===\n");

        // 创建对象
        Vehicle car = new Car();
        Vehicle bike = new Bicycle();

        // 使用接口引用调用方法
        System.out.println("汽车操作:");
        car.start();
        car.stop();

        System.out.println("\n自行车操作:");
        bike.start();
        bike.stop();

        // 演示多态
        System.out.println("\n=== 多态演示 ===");
        operateVehicle(car);
        operateVehicle(bike);
    }

    // 使用接口类型作为参数 - 多态
    public static void operateVehicle(Vehicle v) {
        System.out.println("\n操作交通工具:");
        v.start();
        v.stop();
    }
}