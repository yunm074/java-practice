package cl12;
import java.io.*;
public class Example4 {
    public static void main(String[] args)throws Exception{
        InputStream in = new FileInputStream("E:\\TRAE_Work_CN-Setup-x64.exe");
        OutputStream out = new FileOutputStream("example.txt");
        int len;
        long begintime=System.currentTimeMillis();
        while ((len=in.read())!=-1){
            out.write(len);
        }
        long endtime=System.currentTimeMillis();
        System.out.println("拷贝的时间是："+(endtime-begintime)+"毫秒");
        in.close();
        out.close();
    }
}
