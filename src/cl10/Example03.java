package cl10;
import java.util.*;
public class Example03 {
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add("data_1");
        list.add("data_2");
        list.add("data_3");
        list.add("data_4");
        System.out.println(list);
        ListIterator it=list.listIterator(list.size());
        while (it.hasPrevious()){
            Object obj=it.previous();
         System.out.println(obj+" ");
        }
    }
}
