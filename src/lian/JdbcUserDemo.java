package lian;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUserDemo {
    public static void main(String[] args) {
        // 数据库连接信息，改成你自己的账号密码
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=Asia/Shanghai";
        String user = "root";
        String pwd = "123456";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1.加载驱动（mysql8.0+可省略）
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获取连接
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement();

            // 3.创建users表
            String createSql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(20)," +
                    "age INT)";
            stmt.execute(createSql);
            System.out.println("users表创建成功（已存在则跳过）");

            // 4.插入3条数据
            String insertSql1 = "INSERT INTO users(name,age) VALUES ('张三',18)";
            String insertSql2 = "INSERT INTO users(name,age) VALUES ('李四',20)";
            String insertSql3 = "INSERT INTO users(name,age) VALUES ('王五',22)";
            stmt.executeUpdate(insertSql1);
            stmt.executeUpdate(insertSql2);
            stmt.executeUpdate(insertSql3);
            System.out.println("3条测试数据插入完成");

            // 5.查询所有用户并输出
            String selectSql = "SELECT * FROM users";
            rs = stmt.executeQuery(selectSql);
            System.out.println("\n===== 用户列表 =====");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("id:" + id + ", name:" + name + ", age:" + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try { if(rs != null) rs.close(); } catch (Exception e){}
            try { if(stmt != null) stmt.close(); } catch (Exception e){}
            try { if(conn != null) conn.close(); } catch (Exception e){}
        }
    }
}
