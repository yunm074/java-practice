//定义MaxPriority类,实现了Runnable接口
class MaxPriority implements Runnable {
	//实现run方法
	public void run() {
		for (int i = 0; i < 10; i++) { //循环输出10次
			System.out.println(Thread.currentThread().getName() + "正在输出:" + i);
		}
	}
}

//定义MinPriority类,实现了Runnable接口
class MinPriority implements Runnable {
	//实现run方法
	public void run() {
		for (int i = 0; i < 10; i++) { //循环输出10次
			System.out.println(Thread.currentThread().getName() + "正在输出:" + i);
		}
	}
}

//定义测试类
class Example07 {
	public static void main(String[] args) { //定义main方法
		Thread minPriority = new Thread(new MinPriority(), "优先级较低的线程"); //创建优先级较低的线程
		Thread maxPriority = new Thread(new MaxPriority(), "优先级较高的线程"); //创建优先级较高的线程
		minPriority.setPriority(Thread.MIN_PRIORITY); //设置线程的优先级为1
		maxPriority.setPriority(10); //设置线程的优先级为10
		minPriority.start(); //启动线程
		maxPriority.start(); //启动线程
	}
}
