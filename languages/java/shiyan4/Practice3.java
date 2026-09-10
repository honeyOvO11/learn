package shiyan4;

public class Practice3 {
    public static void main(String[] args) {
        int leftOilVolume = 10;
        GasStation gs = new GasStation();// 实例化对象
        for (int i = 1; i <= 5; i++) {
            leftOilVolume = gs.addOil(leftOilVolume);
        }
        System.out.println("该车现有油量：" + leftOilVolume + "L");
    }
}

class GasStation {
    public int addOil(int oilVolume) {
        oilVolume += 2;
        return oilVolume;
    }
}// 532+19=551
