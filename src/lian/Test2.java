package lian;
//遍历
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printArray(arr);
    }
    //遍历数组的方法
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
