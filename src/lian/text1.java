package lian;
public class text1 {
    public static void main(String[] args) {
        int[] arr = {3,7,4,9,5};
        int target = 9;
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==target){
                index = i;
                break;
            }
        }
        System.out.println("元素"+target+"的索引位置："+index);
    }
}
