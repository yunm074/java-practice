import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example17 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		StringBuffer sb = new StringBuffer(); //创建StringBuffer对象
		int ch; //定义变量ch
		while ((ch = System.in.read()) != -1) { //从标准输入读取字符
			if (ch == '\r' || ch == '\n') { //判断是否为回车或换行
				break; //退出循环
			}
			sb.append((char) ch); //将字符追加到StringBuffer中
		}
		System.out.println(sb); //打印输入的内容
	}
}
