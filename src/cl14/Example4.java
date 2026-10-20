package cl14;
class Example4 {
    public static void main(String[] args) { //定义main方法
        new TicketWindow().start(); //创建线程对象并启动
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start(); //创建-个线程对象 TicketWindow并开启
    }
}

//定义TicketWindow类继承Thread类
class TicketWindow extends Thread {
    private int tickets = 100; //定义剩余票数
    //重写run方法
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
