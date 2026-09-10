
package shiyan6.exa01;

/**
 * 什么是封装?
 * 封装就是将对象中的实现细节隐藏。不被外界所直接访问。
 * 封装的好处?
 * 可以提高代码的安性
 */
public class Student {
    private int age; // 封装--私有化，用private修饰
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
