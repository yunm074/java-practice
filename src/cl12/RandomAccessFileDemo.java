package cl12;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile 随机读写演示：学生记录管理系统
 *
 * 核心思想：把每条记录固定成 30 字节，以后想读写第几条，
 *          就直接 seek 到 30 * 下标 的位置，不用从头遍历。
 *
 * 每条记录 30 字节的内存布局：
 * ┌──────────────┬──────────────┬──────────┐
 * │  id  4 字节  │ name 20 字节 │ age 2字节│ score 4字节 │
 * └──────────────┴──────────────┴──────────┘
 *     int            定长字符串      short      int
 */
public class RandomAccessFileDemo {

    /** 每条记录占用的字节数（定长，随机访问的基础） */
    private static final int NAME_LEN = 20;      // 姓名固定占 20 字节
    private static final int RECORD_SIZE = 4 + NAME_LEN * 2 + 2 + 4;   // = 50 字节

    private static final String FILE = "student.dat";

    // =====================================================================
    // 学生实体
    // =====================================================================
    static class Student {
        int id;
        String name;
        short age;
        int score;

        Student(int id, String name, short age, int score) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("学号=%-4d 姓名=%-8s 年龄=%-3d 成绩=%d", id, name, age, score);
        }
    }

    // =====================================================================
    // 1. 定长写入工具：字符串 -> 固定字节数组
    // =====================================================================
    private static byte[] toFixedBytes(String s, int byteLen) {
        byte[] buf = new byte[byteLen];
        byte[] raw = s.getBytes();
        // 超出部分截断，不足部分补 0（默认值就是 0）
        System.arraycopy(raw, 0, buf, 0, Math.min(raw.length, byteLen));
        return buf;
    }

    private static String fromFixedBytes(byte[] buf) {
        // 尾部补的 0 要去掉，再转成字符串
        return new String(buf).replace("\u0000", "").trim();
    }

    // =====================================================================
    // 2. 写入一条记录（在当前位置写）
    // =====================================================================
    private static void writeRecord(RandomAccessFile raf, Student s) throws IOException {
        raf.writeInt(s.id);                          // 4 字节
        raf.write(toFixedBytes(s.name, NAME_LEN * 2)); // 40 字节（中文按 2 字节算）
        raf.writeShort(s.age);                       // 2 字节
        raf.writeInt(s.score);                       // 4 字节
    }

    // =====================================================================
    // 3. 读取一条记录（从当前位置读）
    // =====================================================================
    private static Student readRecord(RandomAccessFile raf) throws IOException {
        int id = raf.readInt();
        byte[] nameBuf = new byte[NAME_LEN * 2];
        raf.readFully(nameBuf);                      // 保证读满，否则抛 EOFException
        short age = raf.readShort();
        int score = raf.readInt();
        return new Student(id, fromFixedBytes(nameBuf), age, score);
    }

    // =====================================================================
    // 4. 追加一条记录到文件末尾
    // =====================================================================
    public static void append(Student s) throws IOException {
        File f = new File(FILE);
        // "rw" 表示读写模式，文件不存在会自动创建
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            raf.seek(raf.length());                  // 指针移到文件末尾
            writeRecord(raf, s);
        }
        System.out.println("  [追加] " + s);
    }

    // =====================================================================
    // 5. 随机读取第 index 条记录（不用遍历）
    // =====================================================================
    public static Student readAt(int index) throws IOException {
        File f = new File(FILE);
        if (!f.exists()) {
            throw new IOException("文件不存在：" + FILE);
        }
        try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
            long total = raf.length() / RECORD_SIZE;     // 总记录数
            checkBounds(index, total);
            raf.seek(index * RECORD_SIZE);               // ★ 一步跳到目标位置
            return readRecord(raf);
        }
    }

    private static void checkBounds(int index, long total) {
        if (index < 0 || index >= total) {
            throw new IndexOutOfBoundsException(
                    "下标越界：" + index + "，有效范围 0 ~ " + (total - 1));
        }
    }

    // =====================================================================
    // 6. 随机修改第 index 条记录（原地覆盖，长度不变）
    // =====================================================================
    public static void updateAt(int index, Student s) throws IOException {
        File f = new File(FILE);
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            long total = raf.length() / RECORD_SIZE;
            if (index < 0 || index >= total) {
                throw new IndexOutOfBoundsException("下标越界：" + index);
            }
            raf.seek(index * RECORD_SIZE);               // ★ 定位到目标记录
            writeRecord(raf, s);                         // 原地覆盖
            raf.getFD().sync();                          // 强制刷盘，确保落盘
        }
        System.out.println("  [修改] 第 " + index + " 条 -> " + s);
    }

    // =====================================================================
    // 7. 遍历全部记录
    // =====================================================================
    public static void listAll() throws IOException {
        File f = new File(FILE);
        if (!f.exists()) {
            System.out.println("  （文件不存在）");
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
            long total = raf.length() / RECORD_SIZE;
            System.out.println("  共 " + total + " 条记录：");
            for (int i = 0; i < total; i++) {
                raf.seek(i * RECORD_SIZE);
                System.out.printf("    第%d条  %s%n", i, readRecord(raf));
            }
        }
    }

    // =====================================================================
    // 8. 文件信息
    // =====================================================================
    public static void fileInfo() throws IOException {
        File f = new File(FILE);
        if (!f.exists()) {
            System.out.println("  文件还未创建");
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            System.out.printf("  路径=%s  大小=%d 字节  记录数=%d  指针位置=%d%n",
                    f.getAbsolutePath(), raf.length(),
                    raf.length() / RECORD_SIZE, raf.getFilePointer());
        }
    }

    // =====================================================================
    // main：完整演示
    // =====================================================================
    public static void main(String[] args) throws IOException {
        // 每次运行前清空旧文件，保证输出一致
        File old = new File(FILE);
        if (old.exists() && !old.delete()) {
            System.out.println("旧文件删除失败");
        }

        System.out.println("【每条记录 " + RECORD_SIZE + " 字节】");
        System.out.println();

        System.out.println("1) 顺序追加 5 条记录");
        append(new Student(1001, "张三", (short) 18, 88));
        append(new Student(1002, "李四", (short) 19, 92));
        append(new Student(1003, "王五", (short) 18, 75));
        append(new Student(1004, "赵六", (short) 20, 60));
        append(new Student(1005, "钱七", (short) 19, 95));

        System.out.println();
        System.out.println("2) 文件信息");
        fileInfo();

        System.out.println();
        System.out.println("3) 随机读取：直接跳到第 3 条（下标 2），不遍历前面记录");
        System.out.println("   seek(" + 2 + " * " + RECORD_SIZE + ") = " + (2 * RECORD_SIZE) + " 字节处");
        System.out.println("   读到 -> " + readAt(2));

        System.out.println();
        System.out.println("4) 随机修改：把第 3 条的成绩改成 99");
        updateAt(2, new Student(1003, "王五", (short) 18, 99));

        System.out.println();
        System.out.println("5) 修改后再随机读取该条验证");
        System.out.println("   读到 -> " + readAt(2));

        System.out.println();
        System.out.println("6) 遍历全部记录");
        listAll();

        System.out.println();
        System.out.println("7) 异常演示：读取下标 99");
        try {
            readAt(99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("   捕获异常 -> " + e.getMessage());
        }

        System.out.println();
        System.out.println("完成 ✓");
    }
}
