package cl14;
class Example5 {
    public static void main(String[] args) { //定义main方法
        TicketWindow01 tw = new TicketWindow01(); //创建 TicketWindow 实例对象 tw
        new Thread(tw, "窗口1").start(); //创建线程并启动
        new Thread(tw, "窗口2").start();
        new Thread(tw, "窗口3").start();
        new Thread(tw, "窗口4").start();
    }
}

//定义TicketWindow类,实现了Runnable接口
class TicketWindow01 implements Runnable {
    private int tickets = 100; //定义剩余票数
    //实现run方法
    public void run() {
        while (true) { //无限循环
            if (tickets > 0) { //判断是否还有票
                Thread th = Thread.currentThread(); //获取当前线程
                String th_name = th.getName(); //获取线程名称
                System.out.println(th_name + "正在发售第" + tickets-- + "张票"); //打印售票信息
            }
        }
    }
}
