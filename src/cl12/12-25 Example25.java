package cl12;
import java.io.File; //导入File类
import java.io.IOException; //导入IOException类

//定义测试类
class Example25 {
	public static void main(String[] args) { //定义main方法
		File file = new File("example.txt"); //创建File对象
		System.out.println("文件名称:" + file.getName()); //获取文件名称
		System.out.println("文件的相对路径:" + file.getPath()); //获取文件的相对路径
		System.out.println("文件的绝对路径:" + file.getAbsolutePath()); //获取文件的绝对路径
		System.out.println("文件的父路径:" + file.getParent()); //获取文件的父路径
		System.out.println(file.canRead() ? "文件可读" : "文件不可读"); //判断文件是否可读
	}
}
