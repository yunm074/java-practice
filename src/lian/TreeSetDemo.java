package lian;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * HashSet -> TreeSet 转换及 TreeSet 方法完整演示
 *
 * 一、创建 HashSet 并添加元素
 * 二、基于 HashSet 创建 TreeSet（TreeSet 构造器可接收 Collection）
 * 三、输出：所有元素、first()、last()、headSet()、tailSet()、ceiling()
 */
public class TreeSetDemo {

    public static void main(String[] args) {

        // ========== 一、创建 HashSet 并添加元素 ==========
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("李大钊");
        hashSet.add("刘胡兰");
        hashSet.add("董存瑞");
        hashSet.add("黄继光");
        hashSet.add("邱少云");

        System.out.println("========== 一、HashSet（无序，按哈希值存放）==========");
        System.out.println("HashSet 元素：" + hashSet);

        // ========== 二、基于 HashSet 创建 TreeSet ==========
        // TreeSet(Collection<? extends E> c) 构造器：把集合元素全部放入并按自然顺序排序
        TreeSet<String> treeSet = new TreeSet<>(hashSet);

        System.out.println();
        System.out.println("========== 二、TreeSet（自动按 Unicode 升序排序）==========");
        System.out.println("TreeSet 元素：" + treeSet);

        // ========== 三、TreeSet 方法演示 ==========
        System.out.println();
        System.out.println("========== 三、TreeSet 方法演示 ==========");

        // 1. 所有元素（本身已是升序）
        System.out.println("1. 所有元素：" + treeSet);

        // 2. 第一个元素（最小）
        System.out.println("2. first()  第一个元素：" + treeSet.first());

        // 3. 最后一个元素（最大）
        System.out.println("3. last()   最后一个元素：" + treeSet.last());

        // 4~6 用一个中间元素做分隔点，效果更直观
        String pivot = "董存瑞";
        System.out.println();
        System.out.println("   以下以 \"董存瑞\" 作为分隔点演示：");

        // 4. headSet(x)：返回小于 x 的部分（不含 x）
        System.out.println("4. headSet(\"董存瑞\")   小于它的元素：" + treeSet.headSet(pivot));

        // 5. tailSet(x)：返回大于等于 x 的部分（含 x）
        System.out.println("5. tailSet(\"董存瑞\")   大于等于它的元素：" + treeSet.tailSet(pivot));

        // 6. ceiling(x)：返回大于等于 x 的最小元素（没有则返回 null）
        System.out.println("6. ceiling(\"董存瑞\")   大于等于它的最小元素：" + treeSet.ceiling(pivot));

        // ========== 补充：其他常用方法 ==========
        System.out.println();
        System.out.println("========== 补充：其他常用方法 ==========");
        System.out.println("floor(\"董存瑞\")     小于等于它的最大元素：" + treeSet.floor(pivot));
        System.out.println("higher(\"董存瑞\")    严格大于它的最小元素：" + treeSet.higher(pivot));
        System.out.println("lower(\"董存瑞\")     严格小于它的最大元素：" + treeSet.lower(pivot));
        System.out.println("ceiling(\"张三\")     集合中不存在该元素时：" + treeSet.ceiling("张三"));
        System.out.println("floor(\"阿\")         比所有元素都小时：" + treeSet.floor("阿"));
    }
}
