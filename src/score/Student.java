package score;

/**
 * 5.1 Student.java（Model 模型层）
 *
 * 学生实体类：封装学生基本信息。
 * 字段命名与《代码框架》文档保持一致。
 */
public class Student {

    private String studentId;    // 学号
    private String studentName;  // 姓名
    private String gender;       // 性别
    private String className;    // 班级
    private int age;             // 年龄

    /** 无参构造方法 */
    public Student() {
    }

    /** 有参构造方法（不含年龄，年龄默认 0） */
    public Student(String studentId, String studentName, String gender, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.className = className;
    }

    /** 有参构造方法（完整五项） */
    public Student(String studentId, String studentName, String gender, String className, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.className = className;
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
        return studentId + "\t" + studentName + "\t" + gender + "\t" + className + "\t" + age;
    }
}
