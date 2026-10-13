package lian;
import java.util.ArrayList;//简易图书管理系统
import java.util.Scanner;

class Book{
    String name;
    String author;
    double price;
    public Book(String name,String author,double price){
        this.name = name;
        this.author = author;
        this.price = price;
    }
}

public class BookManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        while(true){
            System.out.println("请选择操作:");
            System.out.println("1.添加图书");
            System.out.println("2.显示所有图书");
            System.out.println("3.查找图书");
            System.out.println("4.退出程序");
            int op = sc.nextInt();
            sc.nextLine(); //吸收换行符

            if(op == 1){
                System.out.print("请输入书名：");
                String bookName = sc.nextLine();
                System.out.print("请输入作者：");
                String author = sc.nextLine();
                System.out.print("请输入价格：");
                double price = sc.nextDouble();
                sc.nextLine();
                bookList.add(new Book(bookName,author,price));
                System.out.println("图书添加成功!");
            }else if(op == 2){
                if(bookList.size() == 0){
                    System.out.println("图书馆暂无图书");
                }else{
                    for(Book b : bookList){
                        System.out.println("书名:"+b.name+", 作者:"+b.author+", 价格: "+b.price);
                    }
                }
            }else if(op == 3){
                System.out.print("请输入要查找的图书书名：");
                String searchName = sc.nextLine();
                boolean find = false;
                for(Book b : bookList){
                    if(b.name.equals(searchName)){
                        System.out.println("书名:"+b.name+", 作者:"+b.author+", 价格: "+b.price);
                        find = true;
                        break;
                    }
                }
                if(!find){
                    System.out.println("未找到名为"+searchName+"的图书");
                }
            }else if(op ==4){
                break;
            }
        }
        sc.close();
    }
}
