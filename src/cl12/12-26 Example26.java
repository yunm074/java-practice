import java.io.File; //导入File类

//定义测试类
class Example26 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		File file = new File("f:/Javaproject"); //创建 File 对象
		if (file.isDirectory()) { //判断是否为目录
			String[] names = file.list(); //获取目录下的所有文件名称
			for (String name : names) { //遍历文件名称数组
				System.out.println(name); //输出文件名
			}
		}
	}
}
