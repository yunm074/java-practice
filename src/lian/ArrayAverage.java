package lian;
public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {2,5,8,10,5};
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        double avg = (double)sum / arr.length;
        System.out.println(avg);
    }
}
