public class Practice2_6 {
    public static void main(String[] args) {
        char productGrade = 'A'; // 商品优良等级（字符型）
        double price = 4.8; // 商品单品价格（双精度浮点型）
        int totalSales = 1500; // 商品销售总数（整型）
        boolean hasStock = true; // 是否有库存（布尔型），初始量为true（真~有）
        System.out.println("商品等级：" + productGrade);
        System.out.println("商品单价：" + price);
        System.out.println("销售总量：" + totalSales);
        System.out.println("库存状态：" + (hasStock ? "有库存" : "无库存"));
        // 条件运算符初始量为true所以是有库存
    }
}// 179+13=192行
