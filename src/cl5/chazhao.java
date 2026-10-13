package cl5;
import java.util.Scanner;
public class chazhao {
    public static void main(String[] args){
        int[] nums=new int[]{1,5,8,12,78,24,45,78,99,78,105};
        int num,i;
        int count=0;
        Scanner s=new Scanner(System.in);
        System.out.println("请输入需要查找的整数；");
        num=s.nextInt();
        for (i=0;i<nums.length;i++)
        if(num==nums[i])
        break;
        if(i>9)
        System.out.println("数组不存在该整数"+num);
        else
        System.out.println("数组存在该数字"+num);
        System.out.println("该数字在数组"+(i+1));
    }
}
