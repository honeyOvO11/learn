package shiyan5;

// 抽象工厂类
abstract class Factory {
    public abstract void produce(); // 抽象生产方法
}

// 手机厂类
class PhoneFactory extends Factory {
    @Override
    public void produce() {
        System.out.println("手机厂生产的是手机");
    }
}

// 服装厂类
class ClothesFactory extends Factory {
    @Override
    public void produce() {
        System.out.println("服装厂生产的是衣服");
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        // 创建手机厂并生产
        Factory phoneFactory = new PhoneFactory();
        phoneFactory.produce();

        // 创建服装厂并生产
        Factory clothesFactory = new ClothesFactory();
        clothesFactory.produce();
    }
}