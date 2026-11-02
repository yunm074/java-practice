/*
 * ============================================================
 *  实验二 · 简易聊天室 —— 客户端处理线程
 *  班级：区块链工程CY1班    学号：2025140040125    姓名：周旭
 *
 *  一个客户端对应一条线程：读它发来的消息，然后广播给所有人
 * ============================================================
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;

public class ClientHandler implements Runnable {

    private final Socket socket;
    private String nickname = "游客";          // 昵称
    private PrintWriter out;                   // 这个客户端的输出流
    private boolean joined = false;            // 是否已经加入在线列表

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()))) {

            // 1. 得到输出流（第二个参数 true = 自动刷新，println 后立刻发出）
            out = new PrintWriter(socket.getOutputStream(), true);

            // 2. 客户端发来的第一行就是昵称
            String first = in.readLine();
            if (first != null && !first.trim().isEmpty()) {
                nickname = first.replace("\uFEFF", "").trim();   // 去掉可能带的 BOM
            }

            // 3. 加入在线列表，并通知所有人
            ChatServer.addClient(out);
            joined = true;
            ChatServer.broadcast(time() + "【系统】" + nickname
                    + " 加入了聊天室（当前在线 " + ChatServer.onlineCount() + " 人）");

            // 4. 循环读消息
            String line;
            while ((line = in.readLine()) != null) {
                if ("0".equals(line.trim())) {
                    break;                                        // 输入 0 退出
                }
                ChatServer.broadcast(time() + nickname + "：" + line);
            }
        } catch (Exception e) {
            // 客户端直接关窗口会抛异常，这里忽略
        } finally {
            // 5. 收尾：移出列表 + 通知离开 + 关闭连接
            if (joined && out != null) {
                ChatServer.removeClient(out);
                ChatServer.broadcast(time() + "【系统】" + nickname
                        + " 离开了聊天室（当前在线 " + ChatServer.onlineCount() + " 人）");
            }
            try {
                socket.close();
            } catch (Exception ignored) {
            }
        }
    }

    /** 当前时间，格式 时:分:秒 */
    private String time() {
        LocalTime t = LocalTime.now();
        return "[" + String.format("%02d:%02d:%02d", t.getHour(), t.getMinute(), t.getSecond()) + "] ";
    }
}
