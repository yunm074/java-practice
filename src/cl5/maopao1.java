package cl5;
import java.util.Random;
public class maopao1 {
    public static void main(String[] args){
        int[]nums=new int[10];
        int temp;
        Random ran=new Random();
        System.out.println("随机生成的数组为：");
         for(int i=0;i<10;i++){
             nums[i]= ran.nextInt(1000);
             System.out.print(nums[i]+" ");
         }
        System.out.println();

         for(int j=0;j<9;j++) {
             for (int i = 0; i < 9; i++) {
                 if (nums[i] > nums[i + 1]) {
                     temp = nums[i];
                     nums[i] = nums[i + 1];
                     nums[i + 1] = temp;
                 }
             }
         }
         System.out.println("排序后的数组序列为");
         for(int i=0;i<10;i++){
             System.out.print(nums[i]+" ");
         }


    }

}
