package shiyan5;

// Fruit.java
class Fruit {
    // 定义三个私有变量
    private String name;
    private String area;
    private double price;

    // name的setter和getter方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // area的setter和getter方法
    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    // price的setter和getter方法
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// FruitTest.java
public class FruitTest {
    public static void main(String[] args) {
        // 创建3个水果对象
        Fruit apple = new Fruit();
        Fruit banana = new Fruit();
        Fruit orange = new Fruit();

        // 设置苹果的信息
        apple.setName("苹果");
        apple.setArea("山东");
        apple.setPrice(5.8);

        // 设置香蕉的信息
        banana.setName("香蕉");
        banana.setArea("海南");
        banana.setPrice(3.5);

        // 设置橙子的信息
        orange.setName("橙子");
        orange.setArea("江西");
        orange.setPrice(4.2);

        // 输出水果信息
        System.out.println("水果1：");
        System.out.println("名称：" + apple.getName());
        System.out.println("产地：" + apple.getArea());
        System.out.println("单价：" + apple.getPrice() + "元/斤");
        System.out.println();

        System.out.println("水果2：");
        System.out.println("名称：" + banana.getName());
        System.out.println("产地：" + banana.getArea());
        System.out.println("单价：" + banana.getPrice() + "元/斤");
        System.out.println();

        System.out.println("水果3：");
        System.out.println("名称：" + orange.getName());
        System.out.println("产地：" + orange.getArea());
        System.out.println("单价：" + orange.getPrice() + "元/斤");
    }
}