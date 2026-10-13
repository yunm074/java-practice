package cl10;
import java.util.*; //导入java.util包中的所有类

//定义测试类
class Example29 {
	public static void main(String[] args) { //定义main方法
		int[] arr = {9, 8, 3, 5, 2}; //定义并初始化数组
		System.out.println("排序前:");
		printArray(arr); //调用printArray方法打印数组
		Arrays.sort(arr); //使用Arrays工具类对数组排序
		System.out.println("排序后:");
		printArray(arr); //调用printArray方法打印数组
	}

	//定义静态方法printArray,用于打印数组
	public static void printArray(int[] arr) {
		System.out.print("["); //打印左括号
		for (int x = 0; x < arr.length; x++) { //遍历数组
			if (x != arr.length - 1) { //判断不是最后一个元素
				System.out.print(arr[x] + ","); //打印元素和逗号
			} else {
				System.out.println(arr[x] + "]"); //打印最后一个元素和右括号
			}
		}
	}
}
