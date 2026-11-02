package 算法与综合;
import java.io.*;
import java.util.*;
//数字重排
public class MinNumRearrange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // 跳过前导0
        while (idx < arr.length && arr[idx] == '0') {
            idx++;
        }
        // 全是0的情况
        if (idx == arr.length) {
            System.out.println("0");
            return;
        }
        sb.append(arr[idx]);
        for (int i = 0; i < arr.length; i++) {
            if (i != idx) sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}

