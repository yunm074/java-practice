package cl13;
import java.net.InetAddress;
public class Example1 {
    public static void main(String[] args)throws Exception{
        InetAddress locAddrsss = InetAddress.getLocalHost();
        InetAddress remoteAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("本机的ip地址："+locAddrsss.getHostAddress());
        System.out.println("itcast的ip地址："+remoteAddress.getHostAddress());
        System.out.println("3秒是否可抵达："+remoteAddress.isReachable(3000));
        System.out.println("itcast的主机名为："+remoteAddress.getHostName());
    }
}
