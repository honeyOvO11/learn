public class Practice2_2 {
    final static int A = 1, B = 2;
    final static double C = 3;

    public static void main(String[] args) {
        double x = (A + C) * B / C;
        System.out.println("x的值为：" + x);
        boolean y = A > B | B > C & C > A;// boolean是布尔型判断真假
        System.out.println("y的值为：" + y);
        int a = A + B;
        int b = ++a;
        int c = a++;
        System.out.println("b的值为：" + b + '\t' + "c的值为：" + c);// '\t'是tab长空格键，4或8空格长度
    }
}// 124+15=139行
