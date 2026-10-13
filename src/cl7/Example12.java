package cl7;
class Student02{
    static String schoolName;
}
public class Example12 {
    public static void main(String[] args){
        Student02 stu1=new Student02();
        Student02 stu2=new Student02();
        Student02.schoolName="数字技术产业学院";
        System.out.println("我的学校是"+stu1.schoolName);
        System.out.println("我的学校是"+stu1.schoolName);
    }
}
