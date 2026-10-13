import java.util.Arrays; //导入Arrays类

//定义测试类
class Example32 {
	public static void main(String[] args) { //定义main方法
		int[] arr = {1, 2, 3, 4}; //定义并初始化数组
		Arrays.fill(arr, 8); //使用Arrays工具类将数组所有元素填充为8
		for (int i = 0; i < arr.length; i++) { //遍历数组
			System.out.println(i + ":" + arr[i]); //打印索引和元素
		}
	}
}
