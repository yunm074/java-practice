package 算法与综合;
import java.util.*;
//链表
class Node {
    int val;
    Node next;
    Node(int v) {
        val = v;
        next = null;
    }
}

public class SortedDistinctList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("NULL");
            return;
        }
        Node head = new Node(sc.nextInt());
        Node cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new Node(sc.nextInt());
            cur = cur.next;
        }

        // 去重，有序链表
        Node p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        // 输出
        StringBuilder sb = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            sb.append(tmp.val);
            if (tmp.next != null) {
                sb.append(" -> ");
            }
            tmp = tmp.next;
        }
        System.out.println(sb);
    }
}

