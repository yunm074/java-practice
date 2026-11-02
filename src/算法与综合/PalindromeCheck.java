package 算法与综合;
import java.io.*;
//回文
public class PalindromeCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int l = 0, r = s.length() - 1;
        boolean ok = true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                ok = false;
                break;
            }
            l++;
            r--;
        }
        System.out.println(ok ? "YES" : "NO");
    }
}
