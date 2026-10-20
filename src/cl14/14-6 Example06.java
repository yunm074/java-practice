//定义DaemonThread类,实现了Runnable接口
class DaemonThread implements Runnable {
	//实现run方法
	public void run() {
		while (true) { //无限循环
			System.out.println(Thread.currentThread().getName() + "-is running.");
		}
	}
}

//定义测试类
class Example06 {
	public static void main(String[] args) { //定义main方法
		System.out.println("main线程是后台线程吗?" + Thread.currentThread().isDaemon()); //判断main线程是否为后台线程
		DaemonThread dt = new DaemonThread(); //创建-个 DaemonThread 对象 dt
		Thread t = new Thread(dt, "后台线程"); //创建Thread对象
		System.out.println("t线程默认是后台线程吗?" + t.isDaemon()); //判断t线程是否为后台线程
		t.setDaemon(true); //将t线程设置为后台线程
		t.start(); //启动线程
		for (int i = 0; i < 10; i++) { //循环输出10次
			System.out.println(i);
		}
	}
}
