public class Practice2_3 {
    public static void main(String[] args) {
        int inNum = 37;
        double outNum;
        System.out.println("输入的数为：" + inNum);
        outNum = 9 / 5 * inNum + 32; // 失去精度9/5=1
        System.out.println("输出的数为：" + outNum);
        outNum = 9.0 / 5 * inNum + 32; /*
                                        * 保留了9.0/5=1.8的精度，但是
                                        * 浮点数二进制存储的固有精度问题，
                                        * 1.8*37=66.6的实际存储值可能
                                        * 为66.60000000000001
                                        */
        System.out.println("输出的数为：" + outNum);
    }
}// 139+16=155行
