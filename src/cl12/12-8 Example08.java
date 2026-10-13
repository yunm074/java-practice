package cl12;
import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example08 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		FileReader reader = new FileReader("reader.txt"); //创建文件字符输入流对象
		int ch; //定义-个变量用于记录读取的字符
		while ((ch = reader.read()) != -1) { //循环读取字符
			System.out.println((char) ch); //将读取的字符打印出来
		}
		reader.close(); //关闭文件读取流,释放资源
	}
}
