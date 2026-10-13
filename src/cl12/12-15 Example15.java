package cl12;
import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example01 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		// 创建文件输出流
		FileOutputStream fos = new FileOutputStream("d:/dataStream.txt"); //创建文件输出流对象
		// 使用缓冲流包装
		BufferedOutputStream bos = new BufferedOutputStream(fos); //创建缓冲输出流对象
		// 使用数据输出流包装
		DataOutputStream dos = new DataOutputStream(bos); //创建数据输出流对象
		// 写一个字节
		dos.writeByte(12); //写入一个字节
		// 写一个字符
		dos.writeChar('1'); //写入一个字符
		// 写一个布尔值
		dos.writeBoolean(true); //写入一个布尔值
		// 写一个转换成UTF-8的字符串
		dos.writeUTF("同学,你好"); //写入UTF-8编码的字符串
		// 关闭流
		dos.close(); //关闭数据输出流

		// 创建文件输入流读取数据
		FileInputStream fis = new FileInputStream("d:/dataStream.txt"); //创建文件输入流对象
		BufferedInputStream bis = new BufferedInputStream(fis); //创建缓冲输入流对象
		DataInputStream dis = new DataInputStream(bis); //创建数据输入流对象
		// 读一个字节
		System.out.println(dis.readByte()); //读取一个字节
		// 读一个字符
		System.out.println(dis.readChar()); //读取一个字符
		// 读一个布尔值
		System.out.println(dis.readBoolean()); //读取一个布尔值
		// 读一个转换成UTF-8编码的字符串
		System.out.println(dis.readUTF()); //读取UTF-8编码的字符串
		// 关闭流
		dis.close(); //关闭数据输入流
	}
}
