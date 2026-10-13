import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example18 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		System.setIn(new FileInputStream("source.txt")); //重定向标准输入流到文件
		System.setOut(new PrintStream("target.txt")); //重定向标准输出流到文件
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //创建缓冲字符输入流对象
		String line; //定义字符串变量
		while ((line = br.readLine()) != null) { //循环读取一行
			System.out.println(line); //输出读取的行
		}
		br.close(); //关闭输入流
	}
}
