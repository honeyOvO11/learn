package shiyan6.exa07;

/**
 * toString()方法没有重写之前；
 * return getClass().getName() +'@'+ Integer.toHexString(hashCode())
 * getClass() 获取当前运行对象的字节码对象。
 * getName() 获取包名和类名
 * @ 固定的连接符
 * hashCode()获取模拟出来的内存地址值
 * Integer.toHexString(int num) 将十进制的整数转换成十六进制
 */

public class student {
    String name;
    int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name=" + name + ",age=" + age;
    }
}