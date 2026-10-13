package cl5;
public class Test3 {
    public static void main(String[] args) {
        int[] old = {1, 2, 3};
        int[] bigger = new int[10]; // 创建更长的新数组

        //循环搬运旧数组的数据
        for (int i = 0; i < old.length; i++) {
            bigger[i] = old[i];
        }
        old = bigger; // 让old变量指向新的大数组

        System.out.println("现在数组长度："+old.length);
        System.out.println(old[0]+" "+old[1]+" "+old[2]);
    }
}


