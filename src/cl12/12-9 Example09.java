package cl12;
import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example09 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		FileWriter writer = new FileWriter("writer.txt"); //创建文件字符输出流对象
		String str = "你好,重工"; //定义字符串
		writer.write(str); //将字符串写入文件
		writer.write("\r\n"); //写入换行符
		writer.close(); //关闭输出流
	}
}
