package cl10;
import java.util.*;
import java.util.ArrayList;

public class Example08 {
    public static void main(String[] args) {
        HashSet set=new HashSet();
        set.add("Jack");
        set.add("Annie");
        set.add("Rose");
        set.add("Rose");
        Iterator it= set.iterator();
        while (it.hasNext()){
            Object obj=it.next();
        System.out.println(obj);
        }
    }
}
