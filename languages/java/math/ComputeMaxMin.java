package math; // 声明包名

public class ComputeMaxMin {
    private double[] scores; // 存储成绩的数组

    // 有参构造方法
    public ComputeMaxMin(double[] scores) {
        this.scores = scores;
    }

    // 计算最大值
    public double max() {
        double max = scores[0];
        for (double score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // 计算最小值
    public double min() {
        double min = scores[0];
        for (double score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}