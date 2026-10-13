import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example22 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		FileReader reader = new FileReader("A.txt"); //创建-个 FileReader 对象
		CharArrayWriter caw = new CharArrayWriter(); //创建字符数组输出流对象
		int b; //定义变量b
		while ((b = reader.read()) != -1) { //循环读取字符
			caw.write(b); //将字符写入字符数组输出流
		}
		reader.close(); //关闭输入流
		System.out.println(caw.toString()); //打印字符数组输出流的内容
		caw.close(); //关闭字符数组输出流
	}
}
