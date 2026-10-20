//定义测试类
class Example08 {
	public static void main(String[] args) throws Exception { //定义main方法,抛出异常
		new Thread(new SleepThread()).start(); //创建线程并启动
		for (int i = 1; i <= 10; i++) { //循环10次
			if (i == 5) { //当i等于5时
				Thread.sleep(2000); //主线程休眠2秒
			}
			System.out.println("主线程正在输出:" + i);
			Thread.sleep(500); //当前线程休眠 500 毫秒
		}
	}
}

//定义SleepThread类,实现了Runnable接口
class SleepThread implements Runnable {
	//实现run方法
	public void run() {
		for (int i = 1; i <= 10; i++) { //循环10次
			if (i == 3) { //当i等于3时
				try {
					Thread.sleep(2000); //当前线程休眠2秒
				} catch (InterruptedException e) {
					e.printStackTrace(); //打印异常堆栈
				}
			}
			System.out.println(Thread.currentThread().getName() + "正在输出:" + i);
		}
	}
}
