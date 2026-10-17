package cl12;

import java.util.Scanner;

public class BookPrice {

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
