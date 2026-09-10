package shiyan4;

public class Practice2 {
    public static void main(String args[]) {
        RectConstructor rect1 = new RectConstructor(20, 10);// 创建RectConstructor对象
        double ar;
        ar = rect1.area();
        System.out.println("长方形的面积是" + ar);
    }
}

class RectConstructor {
    private double length;
    private double width;

    double area() {
        return width * length;// 计算并返回长方形面积
    }

    RectConstructor(double width, double length) {
        this.width = width;
        this.length = length;// 构造函数
    }
}// 508+24=532