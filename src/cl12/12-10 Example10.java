package cl12;
import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example10 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		FileReader reader = new FileReader("reader.txt"); //创建文件字符输入流对象
		BufferedReader br = new BufferedReader(reader); //创建缓冲字符输入流对象
		FileWriter writer = new FileWriter("des.txt"); //创建文件字符输出流对象
		BufferedWriter bw = new BufferedWriter(writer); //创建缓冲字符输出流对象
		String str; //定义字符串变量
		while ((str = br.readLine()) != null) { //循环读取一行
			bw.write(str); //将读取的行写入文件
			bw.newLine(); //写人-个换行符,该方法会根据不同的操作系统生成相应的换行符
		}
		br.close(); //关闭输入流
		bw.close(); //关闭输出流
	}
}
