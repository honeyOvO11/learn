import java.util.Scanner;

public class Practice2_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 输入原始密码
        System.out.print("请输入要加密的整数密码: ");
        int originalPassword = scanner.nextInt();

        // 2. 输入加密参数(位移位数)
        System.out.print("请输入加密参数(位移位数, 推荐1-5): ");
        int shift = scanner.nextInt();

        // 3. 加密过程 - 左移
        int encryptedPassword = encrypt(originalPassword, shift);
        System.out.println("加密后的密码: " + encryptedPassword);

        // 4. 解密过程 - 右移
        int decryptedPassword = decrypt(encryptedPassword, shift);
        System.out.println("解密后的密码: " + decryptedPassword);

        // 5. 验证是否还原
        if (originalPassword == decryptedPassword) {
            System.out.println("解密成功，密码还原正确！");
        } else {
            System.out.println("解密失败！");
        }

        scanner.close();
    }

    /**
     * 加密方法 - 使用左移运算符
     * 
     * @param password 原始密码
     * @param shift    位移位数
     * @return 加密后的密码
     */
    public static int encrypt(int password, int shift) {
        // 左移shift位，相当于乘以2的shift次方
        return password << shift;
    }

    /**
     * 解密方法 - 使用右移运算符
     * 
     * @param encryptedPassword 加密后的密码
     * @param shift             位移位数(必须与加密时相同)
     * @return 解密后的原始密码
     */
    public static int decrypt(int encryptedPassword, int shift) {
        // 右移shift位，相当于除以2的shift次方
        return encryptedPassword >> shift;
    }
}// 205+55=260行