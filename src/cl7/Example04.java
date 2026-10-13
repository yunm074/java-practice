package cl7;
class Student01
{
    private int age;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String stuName){
        name= stuName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int stuAge){
        if(stuAge<=0)
        {
            System.out.println("年龄不合格");
        }
        else
        {
            age=stuAge;
        }
    }
    public void introduce(){
        System.out.println("大家好，我叫"+name+",我今年"+age+"岁");

    }
}
public class Example04 {
    public static void main(String[] args){
        Student01 stu=new Student01();
        stu.setAge(-30);
        stu.setName("李芳");
        stu.introduce();
    }
}

