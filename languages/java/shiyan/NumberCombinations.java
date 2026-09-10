public class NumberCombinations {
    public static void main(String[] args) {
        int count = 0; // 计数器，控制每行输出的组合数量

        // 外层循环：遍历十位数字（1到5）
        for (int tensDigit = 1; tensDigit <= 5; tensDigit++) {
            // 内层循环：遍历个位数字（1到5）
            for (int unitsDigit = 1; unitsDigit <= 5; unitsDigit++) {

                // 条件：十位和个位数字不能重复
                if (tensDigit != unitsDigit) {
                    // 组合成两位数（十位*10 + 个位）
                    int number = tensDigit * 10 + unitsDigit;
                    System.out.print(number + " ");
                    count++; // 计数器+1

                    // 每输出5个组合后换行
                    if (count % 5 == 0) {
                        System.out.println();
                    }
                }
            }
        }
    }// 2025年4月8日24行总计24+37=61行
}