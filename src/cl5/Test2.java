package cl5;
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("修改前数组长度："+arr.length);
        System.out.println("修改前内容："+arr[0]+" "+arr[1]+" "+arr[2]);

        arr = new int[10];  // 让变量指向全新数组

        System.out.println("修改后数组长度："+arr.length);
        System.out.println("修改后内容："+arr[0]+" "+arr[1]+" "+arr[2]);
    }
}
