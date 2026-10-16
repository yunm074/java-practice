import java.io.File; //导入File类
import java.io.FilenameFilter; //导入FilenameFilter接口

//定义测试类
class Example27 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		File file = new File("f:/Javaproject"); //创建File对象
		//创建文件名过滤器,使用匿名内部类
		FilenameFilter filter = new FilenameFilter() {
			//实现accept方法
			public boolean accept(File dir, String name) {
				File currFile = new File(dir, name); //创建File对象
				if (currFile.isFile() && name.endsWith(".txt")) { //判断是否为文件且以.txt结尾
					return true; //接受该文件
				}
				return false; //拒绝该文件
			}
		};
		String[] names = file.list(filter); //获取过滤后的文件名称数组
		for (String name : names) { //遍历文件名称数组
			System.out.println(name); //输出文件名
		}
	}
}
