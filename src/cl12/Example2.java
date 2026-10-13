package cl12;
import java.io.*;
public class Example2 {
    public static void main(String[] args)throws  Exception{
        FileOutputStream out=new FileOutputStream("example.txt");
        String str="数字技术产业学院dts";
        byte[] b=str.getBytes();
        for (int i = 0;i<b.length;i++){
            out.write(b[i]);
        }
        out.close();
    }
}
