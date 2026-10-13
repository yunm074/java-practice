package cl7;

class Student{
    String name;
    int age;
    public void introduce(){
        System.out.println("大家好我叫"+name+",我今年"+age+"岁");
    }
}
class Example03{
    public static void main(String[] args){
        Student stu = new Student();
        stu.name = "李芳";
        stu.age = -30;
        stu.introduce();
    }
}
