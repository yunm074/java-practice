package cl2;

public class del {
    public static void main(String[] args){
        int num=5;
        System.out.println(num++);
        System.out.println(num);

        System.out.println(--num);
        System.out.println(num);

        int result=++num+5;
        System.out.println(result);
        result=12+num--;
        System.out.println(result);
    }
}
