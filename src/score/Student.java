package score;

/**
 * 学生实体类：封装学生的基本信息
 */
public class Student {

    private String id;        // 学号
    private String name;      // 姓名
    private String gender;    // 性别
    private String className; // 班级
    private int age;          // 年龄

    /** 无参构造方法 */
    public Student() {
    }

    /** 有参构造方法 */
    public Student(String id, String name, String gender, String className, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.className = className;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "学号=" + id + "，姓名=" + name + "，性别=" + gender
                + "，班级=" + className + "，年龄=" + age;
    }
}
