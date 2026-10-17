package cl12;

import java.util.Scanner;

/**
 * 图书价格统计
 *
 * 输入格式："Java程序设计：34；Web程序设计：56；JSP程序设计：20"
 * 输出格式：逐条打印书目，最后输出总价格
 *
 * 解题思路：
 *   1) 先按中文分号 "；" 拆成每本书的字符串
 *   2) 每本书再按中文冒号 "：" 拆成 书名 和 价格
 *   3) 价格用 Integer.parseInt 转成整数累加
 */
public class BookPrice {

    /**
     * 计算并打印总价格
     *
     * @param record 图书内容字符串，如 "Java程序设计：34；Web程序设计：56"
     * @return 所有书目的总价格
     */
    public static int calcTotal(String record) {
        int total = 0;

        // 按中文分号拆分每本书
        String[] books = record.split("；");

        for (String book : books) {
            // 跳过空串（防止末尾多了分号）
            if (book.trim().isEmpty()) {
                continue;
            }

            // 按中文冒号拆分书名和价格
            String[] parts = book.split("：");
            if (parts.length < 2) {
                continue;                       // 格式不对就跳过
            }

            String name = parts[0].trim();
            int price = Integer.parseInt(parts[1].trim());

            // 输出这一条
            System.out.println(name + "：" + price);
            total += price;
        }

        System.out.println("总价格为" + total);
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            calcTotal(sc.nextLine());
        }
        sc.close();
    }
}
