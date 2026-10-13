import java.util.*; //导入java.util包中的所有类

//定义测试类
class Example30 {
	public static void main(String[] args) { //定义main方法
		int[] arr = {9, 8, 3, 5, 2}; //定义并初始化数组
		Arrays.sort(arr); //使用Arrays工具类对数组排序
		int index = Arrays.binarySearch(arr, 3); //使用二分查找查找元素3的索引
		System.out.println("数组排序后元素3的索引是:" + index); //打印查找结果
	}
}
