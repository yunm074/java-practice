import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example21 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		byte[] bufs = new byte[] {97, 98, 99, 100}; //定义字节数组并初始化
		ByteArrayInputStream bis = new ByteArrayInputStream(bufs); //创建字节数组输入流对象
		int b; //定义变量b
		while ((b = bis.read()) != -1) { //循环读取字节
			System.out.println((char) b); //将字节转换为字符并打印
		}
		bis.close(); //关闭输入流
	}
}
