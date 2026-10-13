package cl10;
import java.util.*; //导入java.util包中的所有类

//定义测试类
class Example28 {
	public static void main(String[] args) { //定义main方法
		ArrayList list = new ArrayList(); //创建ArrayList集合对象
		Collections.addAll(list, -3, 2, 6, 9, 5, 8); //向集合中添加多个元素
		System.out.println("集合中的元素:" + list); //打印集合中的元素
		System.out.println("集合中的最大元素:" + Collections.max(list)); //获取集合中的最大元素
		System.out.println("集合中的最小元素:" + Collections.min(list)); //获取集合中的最小元素
		Collections.replaceAll(list, 8, 0); //将集合中的8替换为0
		System.out.println("替换后的集合:" + list); //打印替换后的集合
	}
}
