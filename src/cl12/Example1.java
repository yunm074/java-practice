package cl12;
import java.io.*;
public class Example1 {
    public static void main(String[] args)throws Exception{
        FileInputStream in = new FileInputStream("test.txt");
        int b=0;
        while (true){
            b = in.read();
            if (b == -1){
                break;
            }
            System.out.println(b);
        }
        in.close();
    }
}
