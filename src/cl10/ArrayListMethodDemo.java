package cl10;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayListMethodDemo {
    public static void main(String[] args) {
        System.out.println("========= 一、Collection 接口的方法 =========");

        Collection<String> c = new ArrayList<>();

        // add(Object o)：向集合中添加一个元素
        c.add("Java");
        c.add("Python");
        c.add("Java");   // List 系集合允许重复元素
        System.out.println("add之后 c = " + c);

        // size()：获取集合元素个数
        System.out.println("size() = " + c.size());

        // contains(Object o)：判断集合中是否包含某个元素
        System.out.println("contains(\"Java\") = " + c.contains("Java"));
        System.out.println("contains(\"C++\")  = " + c.contains("C++"));

        // isEmpty()：判断集合是否为空
        System.out.println("isEmpty() = " + c.isEmpty());

        // remove(Object o)：删除集合中指定的元素（只删找到的第一个）
        c.remove("Java");
        System.out.println("remove(\"Java\")后 c = " + c);

        // iterator()：返回迭代器，用于遍历集合所有元素
        Iterator<String> it = c.iterator();
        System.out.print("iterator()遍历: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 为了演示剩下 3 个方法，再准备一个小集合
        Collection<String> small = new ArrayList<>();
        small.add("C");
        small.add("Go");

        // addAll(Collection c)：把指定集合中的所有元素添加进来
        c.addAll(small);
        System.out.println("addAll(small)后 c = " + c);

        // containsAll(Collection c)：判断是否包含指定集合中的所有元素
        System.out.println("containsAll(small) = " + c.containsAll(small));

        // removeAll(Collection c)：把指定集合中包含的元素全删掉
        c.removeAll(small);
        System.out.println("removeAll(small)后 c = " + c);

        // clear()：删除集合中的所有元素
        c.clear();
        System.out.println("clear()后 c = " + c + "，isEmpty() = " + c.isEmpty());

        System.out.println();
        System.out.println("========= 二、List 接口特有的方法（带索引） =========");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");   // 故意放两个 B，方便演示 indexOf / lastIndexOf
        System.out.println("初始 list = " + list);

        // add(int index, Object element)：在指定索引处插入元素
        list.add(1, "X");
        System.out.println("add(1,\"X\")后 = " + list);

        // get(int index)：返回指定索引处的元素
        System.out.println("get(2) = " + list.get(2));

        // indexOf(Object o)：元素第一次出现的位置索引
        System.out.println("indexOf(\"B\") = " + list.indexOf("B"));

        // lastIndexOf(Object o)：元素最后一次出现的位置索引
        System.out.println("lastIndexOf(\"B\") = " + list.lastIndexOf("B"));

        // set(int index, Object element)：替换指定索引处元素，返回被替换的旧元素
        String old = list.set(2, "Y");
        System.out.println("set(2,\"Y\")：被替换的是 " + old + "，替换后 = " + list);

        // remove(int index)：删除指定索引处的元素，返回被删的元素
        String removed = list.remove(0);
        System.out.println("remove(0)：被删的是 " + removed + "，删除后 = " + list);

        // addAll(int index, Collection c)：在指定索引处插入另一个集合的所有元素
        list.addAll(1, small);
        System.out.println("addAll(1, small)后 = " + list);

        // subList(fromIndex, toIndex)：截取子集合，含头不含尾 [fromIndex, toIndex)
        List<String> sub = list.subList(1, 3);
        System.out.println("subList(1,3) = " + sub);
    }
}
