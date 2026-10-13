import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example20 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		FileInputStream in = new FileInputStream("source.txt"); //创建文件输入流对象
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); //创建-个字节数组输出流对象
		FileOutputStream out = new FileOutputStream("target.txt"); //创建文件输出流对象
		int b; //定义变量b
		while ((b = in.read()) != -1) { //循环读取字节
			bos.write(b); //将字节写入字节数组输出流
		}
		in.close(); //关闭输入流
		bos.close(); //关闭字节数组输出流
		out.write(bos.toByteArray()); //将字节数组输出流的内容写入文件
		out.close(); //关闭输出流
	}
}
