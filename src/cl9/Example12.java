package cl9;

public class Example12 {
    public static void main(String[] args){
        Runtime rt=Runtime.getRuntime();
        System.out.println("处理器的个数："+rt.availableProcessors()+"个");
        System.out.println("空闲的处理器个数："+rt.freeMemory()+"M");
        System.out.println("最大可用内存："+rt.maxMemory()+"M");

    }
}
