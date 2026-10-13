import java.io.*; //导入java.io包中的所有类

//定义测试类
class Example19 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		final PipedInputStream pis = new PipedInputStream(); //创建 PipedInputStream管道输入流对象,使用final关键字修饰
		final PipedOutputStream pos = new PipedOutputStream(); //创建管道输出流对象
		pis.connect(pos); //连接管道输入流和输出流
		//创建线程,使用匿名内部类
		new Thread(new Runnable() {
			//实现run方法
			public void run() {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //创建缓冲字符输入流对象
				PrintStream ps = new PrintStream(pos); //创建打印流对象,连接管道输出流
				while (true) { //无限循环
					try {
						System.out.print(Thread.currentThread().getName() + "要求输入内容:");
						ps.println(br.readLine()); //将输入的内容写入管道
						Thread.sleep(1000); //线程休眠1秒
					} catch (Exception e) {}
				}
			}
		}).start(); //启动线程
		//创建线程,使用匿名内部类
		new Thread(new Runnable() {
			//实现run方法
			public void run() {
				BufferedReader br = new BufferedReader(new InputStreamReader(pis)); //创建缓冲字符输入流对象,连接管道输入流
				while (true) { //无限循环
					try {
						System.out.println(Thread.currentThread().getName() + "收到:" + br.readLine()); //从管道读取内容
					} catch (Exception e) {}
				}
			}
		}).start(); //启动线程
	}
}
