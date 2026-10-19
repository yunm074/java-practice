package cl13;
import java.awt.*; //导入java.awt包中的所有类
import java.awt.event.*; //导入java.awt.event包中的所有类
import javax.swing.*; //导入javax.swing包中的所有类
import java.io.IOException; //导入IOException类
import java.net.*; //导入java.net包中的所有类

//定义GuiChat类继承JFrame类
class GuiChat extends JFrame {
    private static final int DEFAULT_PORT = 8899; //定义静态常量作为默认端口号
    // 把主窗口分为 NORTH、CENTER和 SOUTH 三个部分
    private JLabel stateLB; // 显示监听状态
    private JTextArea centerTextArea; // 显示聊天记录
    private JPanel southPanel; // 最下面的面板
    private JTextArea inputTextArea; // 聊天输入框
    private JPanel bottomPanel; // 放置IP输入框,按钮等
    private JTextField ipTextField; // IP输入框
    private JTextField remotePortTF; // 端口号输入框
    private JButton sendBT; // 发送按钮
    private JButton clearBT; // 清除聊天记录按钮
    private DatagramSocket datagramSocket; // 用于后面功能的实现

    //定义构造方法
    public GuiChat() {
        setUpUI(); //调用setUpUI方法初始化界面
        initSocket(); //调用initSocket方法初始化套接字
        setListener(); //调用setListener方法设置监听器
    }

    //定义私有方法setUpUI,用于初始化界面
    private void setUpUI() {
        // 初始化Swing窗口
        setTitle("GUI聊天"); //设置窗口标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭操作
        setSize(400, 400); // 设置窗口的大小
        setResizable(false); // 窗口大小不可调整
        setLocationRelativeTo(null); // 窗口居中
        // 窗口的NORTH部分
        stateLB = new JLabel("当前还未启动监听"); //创建状态标签
        stateLB.setHorizontalAlignment(JLabel.RIGHT); //设置标签右对齐
        // 窗口的CENTER部分
        centerTextArea = new JTextArea(); // 聊天记录显示区域
        centerTextArea.setEditable(false); //设置不可编辑
        centerTextArea.setBackground(new Color(211, 211, 211)); //设置背景色
        // 窗口的SOUTH部分
        southPanel = new JPanel(new BorderLayout()); //创建南层面板
        inputTextArea = new JTextArea(5, 20); // 内容输入区域
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5)); //创建底部面板
        ipTextField = new JTextField("127.0.0.1", 8); //创建IP输入框
        remotePortTF = new JTextField(String.valueOf(DEFAULT_PORT), 3); //创建端口号输入框
        sendBT = new JButton("发送"); //创建发送按钮
        clearBT = new JButton("清屏"); //创建清屏按钮
        bottomPanel.add(ipTextField); //向底部面板添加组件
        bottomPanel.add(remotePortTF);
        bottomPanel.add(sendBT);
        bottomPanel.add(clearBT);
        southPanel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER); //向南部面板添加滚动面板
        southPanel.add(bottomPanel, BorderLayout.SOUTH);
        // 添加窗口NORTH、CENTER、SOUTH部分的组件
        add(stateLB, BorderLayout.NORTH); //向窗口北部添加状态标签
        add(new JScrollPane(centerTextArea), BorderLayout.CENTER); //向窗口中部添加聊天记录区域
        add(southPanel, BorderLayout.SOUTH); //向窗口南部添加南层面板
        setVisible(true); //设置窗口可见
    }

    //定义私有方法setListener,用于设置事件监听器
    private void setListener() {
        // 为sendBT按钮添加事件监听器
        sendBT.addActionListener(new ActionListener() {
            //实现actionPerformed方法
            public void actionPerformed(ActionEvent e) {
                // 获取发送的目标ip地址和端口号
                final String ipAddress = ipTextField.getText(); //获取IP地址
                final String remotePort = remotePortTF.getText(); //获取端口号
                // 判断ip地址和端口号是否为空
                if (ipAddress == null || ipAddress.trim().equals("")
                        || remotePort == null || remotePort.trim().equals("")) {
                    JOptionPane.showMessageDialog(GuiChat.this, "请输入IP地址和端口号!"); //弹出提示对话框
                    return;
                }
                if (datagramSocket == null || datagramSocket.isClosed()) { //判断套接字是否可用
                    JOptionPane.showMessageDialog(GuiChat.this, "监听不成功!"); //弹出提示对话框
                    return;
                }
                // 获得需要发送的内容
                String sendContent = inputTextArea.getText(); //获取输入的内容
                byte[] buf = sendContent.getBytes(); //将内容转换为字节数组
                try {
                    // 将发送的内容显示在自己的聊天记录中
                    centerTextArea.append("我对" + ipAddress + ":" + remotePort
                            + "说:\n" + inputTextArea.getText() + "\n\n"); //向聊天记录中添加发送内容
                    // 添加内容后,使滚动条自动滚动到最底端
                    centerTextArea.setCaretPosition(centerTextArea.getText().length()); //设置滚动条位置
                    // 发送数据
                    datagramSocket.send(new DatagramPacket(buf, buf.length,
                            InetAddress.getByName(ipAddress), Integer.parseInt(remotePort))); //发送数据包
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(GuiChat.this, "出错了,发送不成功!"); //弹出错误提示
                    e1.printStackTrace(); //打印异常堆栈
                }
                inputTextArea.setText(""); //清空输入框
            }
        });
        // 为clearBT按钮添加事件监听器
        clearBT.addActionListener(new ActionListener() {
            //实现actionPerformed方法
            public void actionPerformed(ActionEvent e) {
                centerTextArea.setText(""); // 清空聊天记录的内容
            }
        });
    }

    //定义私有方法initSocket,用于初始化套接字
    private void initSocket() {
        int port = DEFAULT_PORT; //定义端口号变量
        while (true) { //循环直到成功绑定端口
            try {
                if (datagramSocket != null && !datagramSocket.isClosed()) { //判断套接字是否存在且未关闭
                    datagramSocket.close(); //关闭套接字
                }
                try {
                    // 判断端口号是否在1~65535
                    port = Integer.parseInt(JOptionPane.showInputDialog(this,
                            "请输入端口号", "端口号", JOptionPane.QUESTION_MESSAGE)); //弹出输入对话框获取端口号
                    if (port < 1 || port > 65535) { //判断端口号范围
                        throw new RuntimeException("端口号超出范围"); //抛出异常
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "你输入的端口不正确,请输入1~65535的数"); //弹出错误提示
                    continue; // 端口不正确重新填写
                }
                // 启动DatagramSocket
                datagramSocket = new DatagramSocket(port); //创建DatagramSocket对象
                startListen(); // 调用startListen方法
                // 在stateLB中显示程序监听的端口号
                stateLB.setText("已在" + port + "端口监听"); //更新状态标签
                break; //退出循环
            } catch (SocketException e) {
                // 端口号被占用重新填写
                JOptionPane.showMessageDialog(this, "端口已被占用,请重新设置端口!"); //弹出提示对话框
                stateLB.setText("当前还未启动监听"); //更新状态标签
            }
        }
    }

    //定义私有方法startListen,用于启动监听线程
    private void startListen() {
        new Thread() { //创建线程
            private DatagramPacket p; //定义数据包变量
            //重写run方法
            public void run() {
                byte[] buf = new byte[1024]; //定义缓冲区字节数组
                // 创建DatagramPacket
                p = new DatagramPacket(buf, buf.length); //创建数据包对象
                while (!datagramSocket.isClosed()) { //循环接收数据
                    try {
                        datagramSocket.receive(p); // 接收聊天消息
                        // 添加到聊天记录框
                        centerTextArea.append(p.getAddress().getHostAddress()
                                + ":" + ((InetSocketAddress) p.getSocketAddress()).getPort()
                                + "对我说:\n" + new String(p.getData(), 0, p.getLength())
                                + "\n\n"); //向聊天记录添加接收到的消息
                        // 使滚动条自动滚动到最底端
                        centerTextArea.setCaretPosition(centerTextArea.getText().length()); //设置滚动条位置
                    } catch (IOException e) {
                        e.printStackTrace(); //打印异常堆栈
                    }
                }
            }
        }.start(); //启动线程
    }

    //定义main方法
    public static void main(String[] args) {
        new GuiChat(); //创建GuiChat对象
    }
}