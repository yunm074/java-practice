package cl6;

public class ExchangeTest2
{
    public static void main(String[] args)
    {
        int[] n={5,10};
        System.out.println("调用exchange方法前n[0]n[1]的值为"+n[0]+","+n[1]);
        exchange(n);
        System.out.println("调用exchange方法后n[0]n[1]的值为"+n[0]+","+n[1]);
    }
    public static void exchange(int[] nums)
    {
        int temp;
        temp=nums[0];
        nums[0]=nums[1];
        nums[1]=temp;
    }
}
