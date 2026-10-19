package cl13;
import java.net.*; //导入java.net包中的所有类

//定义测试类
class Example3 {
    public static void main(String[] args) throws Exception { //定义main方法,抛出异常
        DatagramSocket ds = new DatagramSocket(3000); //创建DatagramSocket对象,绑定3000端口
        String str = "hello world"; //要发送的数据
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(),
                InetAddress.getByName("localhost"), 8954); //创建数据包对象,指定目标地址和端口
        System.out.println("发送信息");
        ds.send(dp); //发送数据
        ds.close(); //释放资源
    }
}