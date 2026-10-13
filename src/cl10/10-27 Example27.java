package cl10;

import java.util.*; //导入java.util包中的所有类

//定义测试类
class Example27 {
	public static void main(String[] args) { //定义main方法
		ArrayList list = new ArrayList(); //创建ArrayList集合对象
		Collections.addAll(list, "C", "z", "B", "K"); //向集合中添加多个元素
		System.out.println("排序前:" + list); //打印排序前的集合
		Collections.reverse(list); //反转集合中的元素
		System.out.println("反转后:" + list); //打印反转后的集合
		Collections.sort(list); //对集合进行自然排序
		System.out.println("按自然顺序排序后:" + list); //打印排序后的集合
		Collections.shuffle(list); //对集合中的元素进行随机排列
		System.out.println("洗牌后:" + list); //打印洗牌后的集合
	}
}
