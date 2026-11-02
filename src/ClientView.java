/*
 * ============================================================
 *  实验二 · 简易聊天室 —— 客户端
 *  班级：区块链工程CY1班    学号：2025140040125    姓名：周旭
 *
 *  运行方式：在 IDEA 里右键本文件 → Run 'ClientView.main()'
 *  想同时开两个客户端：Run → Edit Configurations → 勾选
 *  "Allow multiple instances"，然后再点一次 Run
 * ============================================================
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientView {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {

        // 个性化标题（含本人姓名、学号）
        System.out.println("==================================================");
        System.out.println("      实验二 · 简易聊天室   客户端");
        System.out.println("      周旭    2025140040125");
        System.out.println("      班级：区块链工程CY1班");
        System.out.println("==================================================");

        // 1. 连接服务端
        Socket socket = new Socket(HOST, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        Scanner keyboard = new Scanner(System.in);

        // 2. 输入昵称（用本人姓名或学号）
        System.out.print("请输入昵称（建议用姓名或学号）：");
        String nickname = keyboard.nextLine().trim();
        if (nickname.isEmpty()) {
            nickname = "2025140040125";
        }
        out.println(nickname);

        // 3. 单独开一条线程负责“收”，避免和键盘输入抢控制台
        Thread receiver = new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception ignored) {
            }
            System.out.println("【与服务端的连接已断开】");
        });
        receiver.setDaemon(true);
        receiver.start();

        System.out.println("已进入聊天室，直接输入内容回车发送；输入 0 退出。");
        System.out.println("--------------------------------------------------");

        // 4. 主线程负责“发”
        while (true) {
            String msg = keyboard.nextLine();
            if ("0".equals(msg.trim())) {
                break;
            }
            out.println(msg);
        }

        // 5. 退出
        out.println("0");
        socket.close();
        System.out.println("已退出聊天室，再见！");
    }
}
