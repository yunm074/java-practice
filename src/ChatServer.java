/*
 * ============================================================
 *  实验二 · 简易聊天室 —— 服务端
 *  班级：区块链工程CY1班    学号：2025140040125    姓名：周旭
 *
 *  运行方式：在 IDEA 里右键本文件 → Run 'ChatServer.main()'
 *  程序会一直监听 8888 端口，等客户端连进来（窗口不要关）
 * ============================================================
 */
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    /** 服务端口：客户端要连这个端口 */
    public static final int PORT = 8888;

    /** 所有在线客户端的输出流，广播时就是遍历它 */
    private static final List<PrintWriter> online = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        实验二 · 简易聊天室   服务端");
        System.out.println("        周旭    2025140040125");
        System.out.println("==================================================");

        try (ServerSocket server = new ServerSocket(PORT)) {
            // 允许端口复用，避免刚关掉又立刻启动时报“端口被占用”
            server.setReuseAddress(true);
            System.out.println("服务端已启动，正在监听端口 " + PORT + " ...");
            System.out.println("等待客户端连接（可以同时开多个客户端）");
            System.out.println("--------------------------------------------------");

            while (true) {
                Socket socket = server.accept();          // 阻塞等待连接
                System.out.println("有新客户端连接：" + socket.getRemoteSocketAddress());
                // 每个客户端一条线程
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            System.out.println("服务端启动失败：" + e.getMessage());
        }
    }

    /** 客户端上线：加入在线列表 */
    public static synchronized void addClient(PrintWriter out) {
        online.add(out);
    }

    /** 客户端下线：移出在线列表 */
    public static synchronized void removeClient(PrintWriter out) {
        online.remove(out);
    }

    /** 群发：把消息发给列表里的每一个客户端 */
    public static synchronized void broadcast(String msg) {
        for (PrintWriter out : online) {
            out.println(msg);
        }
    }

    /** 当前在线人数 */
    public static synchronized int onlineCount() {
        return online.size();
    }
}
