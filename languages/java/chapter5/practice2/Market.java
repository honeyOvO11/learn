package chapter5.practice2;

public abstract class Market {
    public String name;
    public String goods;

    Market(String name, String goods) {
        this.name = name;
        this.goods = goods;
    }

    public abstract void shop();
}

class WuMeiMarket extends Market {
    WuMeiMarket(String name, String goods) {
        super(name, goods);
    }

    public void shop() {
        System.out.println(name + "实体店购买" + goods);
    }
}

class JDMarket extends Market {
    JDMarket(String name, String goods) {
        super(name, goods);
    }

    public void shop() {
        System.out.println(name + "网购" + goods);
    }
}