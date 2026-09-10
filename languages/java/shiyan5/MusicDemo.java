package shiyan5;

// 1. 定义乐器抽象类
abstract class Instrument {
    public abstract void makeSound(); // 抽象方法：发出声音
}

// 2. 定义乐器子类
// 二胡类
class Erhu extends Instrument {
    private String piece; // 曲目

    public Erhu(String piece) {
        this.piece = piece;
    }

    @Override
    public void makeSound() {
        System.out.println("弹奏的曲目是" + piece);
    }
}

// 钢琴类
class Piano extends Instrument {
    private String piece; // 曲目

    public Piano(String piece) {
        this.piece = piece;
    }

    @Override
    public void makeSound() {
        System.out.println("弹奏的曲目是" + piece);
    }
}

// 小提琴类
class Violin extends Instrument {
    private String piece; // 曲目

    public Violin(String piece) {
        this.piece = piece;
    }

    @Override
    public void makeSound() {
        System.out.println("弹奏的曲目是" + piece);
    }
}

// 3. 定义乐手类
class Musician {
    private String name; // 乐手姓名

    public Musician(String name) {
        this.name = name;
    }

    // 弹奏乐器的方法
    public void play(Instrument instrument) {
        String instrumentType = "";

        // 判断乐器类型
        if (instrument instanceof Erhu) {
            instrumentType = "二胡";
        } else if (instrument instanceof Piano) {
            instrumentType = "钢琴";
        } else if (instrument instanceof Violin) {
            instrumentType = "小提琴";
        }

        System.out.print(name + "弹奏的乐器是" + instrumentType + "，");
        instrument.makeSound(); // 调用乐器发声方法
    }
}

// 4. 主类
public class MusicDemo {
    public static void main(String[] args) {
        Musician musician = new Musician("张三");

        // 创建不同的乐器
        Instrument piano = new Piano("夜光");
        Instrument erhu = new Erhu("二泉映月");
        Instrument violin = new Violin("沉思");

        // 乐手弹奏不同的乐器
        musician.play(piano);
        musician.play(erhu);
        musician.play(violin);
    }
}