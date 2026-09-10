
package shiyan6.exa08;

public class Cat extends Animal {
    public Cat() {
        super("波斯猫", 1);
    }

    public void sing() {
        super.sing();
        System.out.println("猫会唱");
    }

    public void rap() {
        super.rap();
        System.out.println("猫会rap");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sing();
        cat.rap();
    }
}