package cl14;

public class Example3 {
    public static void main(String[] args){
        MyThread01 myThread01 = new MyThread01();
        Thread thread=new Thread(myThread01);
        thread.start();
        while (true){
            System.out.println("main()方法在运行");

        }
    }
}
class MyThread01 implements Runnable{
    public void run(){
        while (true){
            System.out.println("MyThread类的run（）方法在运行");
        }
    }
}

