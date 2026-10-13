package cl12;
import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example16 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		PrintStream ps = new PrintStream(new FileOutputStream("printStream.txt"), true); //创建打印流对象
		Student stu = new Student(); //创建Student对象
		ps.print("这是一个数字:"); //打印字符串
		ps.println(19); //打印数字
		ps.println(stu); //打印 Student 对象
		ps.close(); //关闭打印流
	}
}

//定义Student类
class Student {
	//重写toString方法
	public String toString() {
		return "我是一个学生";
	}
}
