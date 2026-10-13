package lian;

public class max {
    public static void main(String[] args){
        int[] arr = {12, 45, 78, 34, 23};
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
