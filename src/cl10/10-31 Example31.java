import java.util.*; //导入java.util包中的所有类

//定义测试类
class Example31 {
	public static void main(String[] args) { //定义main方法
		int[] arr = {9, 8, 3, 5, 2}; //定义并初始化数组
		int[] copied = Arrays.copyOfRange(arr, 1, 7); //使用Arrays工具类拷贝数组指定范围
		for (int i = 0; i < copied.length; i++) { //遍历拷贝后的数组
			System.out.print(copied[i] + " "); //打印元素
		}
		System.out.println();
	}
}
