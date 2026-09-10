package shiyan6.exa14;

/**
 * 创建内部类对象的格式：
 * 外部类.内部类 对象名 = new 外部类（）.new 内部类（）
 * 成员内部类可以访问外部类的所有成员，无论外部类的成员是何种访问权限。s
 */
// 简单版外部类
class University {
    private String universityName;

    public University(String name) {
        this.universityName = name;
    }

    // 成员内部类 - 学院
    class College {
        private String collegeName;

        public College(String name) {
            this.collegeName = name;
        }

        public void showInfo() {
            System.out.println(collegeName + "学院属于" + universityName);
        }

        public void accessUniversity() {
            System.out.println("内部类可以访问外部类的名字: " + universityName);
        }
    }

    // 外部类方法创建内部类
    public College createCollege(String name) {
        return new College(name);
    }

    // 外部类访问内部类
    public void manageCollege() {
        College computerCollege = new College("计算机");
        computerCollege.showInfo();
    }
}

public class exa {
    public static void main(String[] args) {
        // 创建外部类
        University university = new University("清华大学");

        // 创建内部类方式1：通过外部类实例
        University.College college1 = university.new College("物理");
        college1.showInfo();
        college1.accessUniversity();

        // 创建内部类方式2：通过外部类方法
        University.College college2 = university.createCollege("数学");
        college2.showInfo();

        // 外部类访问内部类
        university.manageCollege();

        // 链式创建
        University.College college3 = new University("北京大学").new College("化学");
        college3.showInfo();
    }
}