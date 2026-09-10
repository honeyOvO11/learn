package shiyan4;

class Practice1 {
    public static int x = 100, y = 100;
    public int r;

    public static void main(String args[]) {
        Practice1 t1 = new Practice1();
        Practice1 t2 = new Practice1();
        t1.x += 100;
        t1.r = 50;
        t2.x += 200;
        t2.r = 150;
        System.out.println("Circlel:x=" + t1.x + ",y=" + t1.y + ",r=" + t1.r);
        System.out.println("Circle2:x=" + t2.x + ",y=" + t2.y + ",r=" + t2.r);
    }// x和y为静态变量应该通过类名访问（如Practice1.x），而不是通过实例访问，虽然结果没问题
}// 491+17=508