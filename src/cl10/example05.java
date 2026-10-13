package cl10;
import java.util.*;
public class example05 {
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add("Jack");
        list.add("Annie");
        list.add("Rose");
        list.add("Tom");
        Iterator it=list.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            if ("Annie".equals(obj)){
                list.remove(obj);
            }
        }
        System.out.println(list);
    }
}
