package cl12;
import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example13 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		Person p = new Person("p1", "zhangsan", 20); //创建-个 Person 对象
		System.out.println("---写入文件前---");
		System.out.println("Person对象的id:" + p.getId()); //获取id属性
		System.out.println("Person对象的name:" + p.getName()); //获取name属性
		System.out.println("Person对象的age:" + p.getAge()); //获取age属性
		FileOutputStream fos = new FileOutputStream("objectStream.txt"); //创建文件输出流对象
		ObjectOutputStream oos = new ObjectOutputStream(fos); //创建对象输出流对象
		oos.writeObject(p); //将对象写入文件
		oos.close(); //关闭对象输出流
		fos.close(); //关闭文件输出流
	}
}

//定义Person类,实现了Serializable接口
class Person implements Serializable {
	private String id; //将id属性私有化
	private String name; //将name属性私有化
	private int age; //将age属性私有化
	//定义构造方法
	public Person(String id, String name, int age) {
		this.id = id; //为id属性赋值
		this.name = name; //为name属性赋值
		this.age = age; //为age属性赋值
	}
	public String getId() { return id; } //定义获取id的方法
	public String getName() { return name; } //定义获取name的方法
	public int getAge() { return age; } //定义获取age的方法
}
