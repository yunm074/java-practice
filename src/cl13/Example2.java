package cl13;
import java.net.*;
import java.util.Date;

class Example2 {
    public static void main(String[] args) throws Exception { //定义main方法,抛出异常
        byte[] buf = new byte[1024]; //定义缓冲区字节数组
        DatagramSocket ds = new DatagramSocket(8954); //创建DatagramSocket对象,绑定8954端口
        DatagramPacket dp = new DatagramPacket(buf, 1024); //创建DatagramPacket数据包对象
        System.out.println("等待接收数据");
        ds.receive(dp); //等待接收数据,如果没有数据则会阻塞
        String str = new String(dp.getData(), 0, dp.getLength()) + " from "
                + dp.getAddress().getHostAddress() + ":" + dp.getPort(); //获取接收到的数据和发送方信息
        System.out.println(str); //打印接收到的信息
        ds.close(); //关闭DatagramSocket对象
    }
}