package shiyan5;

// 定义DadLikeDo接口
interface DadLikeDo {
    void ride(); // 爸爸喜欢骑车

    void basketball(); // 爸爸喜欢打篮球
}

// 定义MonLikeDo接口
interface MonLikeDo {
    void sing(); // 妈妈喜欢唱歌

    void dance(); // 妈妈喜欢跳舞
}

// SonLikeDo类实现两个接口
class SonLikeDo implements DadLikeDo, MonLikeDo {
    @Override
    public void ride() {
        System.out.println("儿子继承了爸爸的爱好：喜欢骑车");
    }

    @Override
    public void basketball() {
        System.out.println("儿子继承了爸爸的爱好：喜欢打篮球");
    }

    @Override
    public void sing() {
        System.out.println("儿子继承了妈妈的爱好：喜欢唱歌");
    }

    @Override
    public void dance() {
        System.out.println("儿子继承了妈妈的爱好：喜欢跳舞");
    }
}

public class FamilyHobbies {
    public static void main(String[] args) {
        SonLikeDo son = new SonLikeDo();

        System.out.println("儿子的爱好：");
        son.ride(); // 来自爸爸的爱好
        son.basketball(); // 来自爸爸的爱好
        son.sing(); // 来自妈妈的爱好
        son.dance(); // 来自妈妈的爱好
    }
}