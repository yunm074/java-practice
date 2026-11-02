package 算法与综合;
import java.io.*;
//二进制加法
public class BinaryAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int numA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int numB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = numA + numB + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        // 反转得到结果
        System.out.println(sb.reverse());
    }
}
