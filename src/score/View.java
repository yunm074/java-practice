package score;

import java.util.List;
import java.util.Scanner;

/**
 * 5.5 View.java（View 视图层 + 程序入口）
 *
 * 职责：
 *   1) 展示菜单、读取键盘输入；
 *   2) 格式化输出数据与统计结果；
 *   3) 提供 main 方法作为程序入口（框架未单列 Main 文件，故并入此处，
 *      以保证整体正好 5 个文件）。
 *
 * 注意：本类只调用 Controller，不认识 Service 和 Dao。
 */
public class View {

    /** 控制层对象，界面所有请求都通过它转发 */
    private static final StudentController controller = new StudentController();

    /** 键盘输入 */
    private static final Scanner scanner = new Scanner(System.in);

    // =====================================================================
    // 程序入口
    // =====================================================================

    public static void main(String[] args) {
        runProgram();
    }

    // =====================================================================
    // 主循环
    // =====================================================================

    public static void runProgram() {
        while (true) {
            showMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    studentMenu();
                    break;
                case "2":
                    scoreMenu();
                    break;
                case "3":
                    queryMenu();
                    break;
                case "0":
                    System.out.println("感谢使用，再见！");
                    return;
                default:
                    System.out.println("输入有误，请重选");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println();
        // TODO: 把下面姓名、学号改成你自己的
        System.out.println("======== 学生成绩管理系统-周旭-2025140040125 ========");
        System.out.println("1. 学生信息管理");
        System.out.println("2. 成绩信息管理");
        System.out.println("3. 成绩查询与统计");
        System.out.println("0. 退出系统");
        System.out.print("请选择：");
    }

    // =====================================================================
    // 子菜单：学生信息管理
    // =====================================================================

    private static void studentMenu() {
        while (true) {
            System.out.println();
            System.out.println("----- 学生信息管理 -----");
            System.out.println("1. 增加学生   2. 修改学生   3. 删除学生");
            System.out.println("4. 按学号查询 5. 显示全部   0. 返回");
            System.out.print("请选择：");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addStudentView();
                    break;
                case "2":
                    editStudentView();
                    break;
                case "3":
                    deleteStudentView();
                    break;
                case "4":
                    queryStudentView();
                    break;
                case "5":
                    displayStudents(controller.getAllStudents());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误，请重选");
            }
        }
    }

    /** 增加学生 */
    private static void addStudentView() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("学号不能为空！");
            return;
        }
        System.out.print("请输入姓名：");
        String name = scanner.nextLine().trim();
        System.out.print("请输入性别：");
        String gender = scanner.nextLine().trim();
        System.out.print("请输入班级：");
        String className = scanner.nextLine().trim();
        System.out.print("请输入年龄：");
        int age = readInt();

        if (controller.addStudent(id, name, gender, className, age)) {
            System.out.println("添加学生成功！");
        } else {
            System.out.println("添加失败：学号 " + id + " 已存在！");
        }
    }

    /** 修改学生 */
    private static void editStudentView() {
        displayStudents(controller.getAllStudents());
        System.out.print("请输入要修改的学生学号：");
        String id = scanner.nextLine().trim();
        if (!controller.isStudentExist(id)) {
            System.out.println("修改失败：学号 " + id + " 不存在！");
            return;
        }
        System.out.print("请输入新姓名：");
        String name = scanner.nextLine().trim();
        System.out.print("请输入新性别：");
        String gender = scanner.nextLine().trim();
        System.out.print("请输入新班级：");
        String className = scanner.nextLine().trim();
        System.out.print("请输入新年龄：");
        int age = readInt();

        Student student = new Student(id, name, gender, className, age);
        if (controller.updateStudent(student)) {
            System.out.println("修改学生信息成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    /** 删除学生（级联删除其成绩） */
    private static void deleteStudentView() {
        System.out.print("请输入要删除的学生学号：");
        String id = scanner.nextLine().trim();
        int removed = controller.deleteStudent(id);
        if (removed < 0) {
            System.out.println("删除失败：学号 " + id + " 不存在！");
        } else {
            System.out.println("删除学生成功，同时删除其成绩 " + removed + " 条。");
        }
    }

    /** 按学号查询学生 */
    private static void queryStudentView() {
        System.out.print("请输入要查询的学号：");
        String id = scanner.nextLine().trim();
        displayStudent(controller.getStudentById(id));
    }

    // =====================================================================
    // 子菜单：成绩信息管理
    // =====================================================================

    private static void scoreMenu() {
        while (true) {
            System.out.println();
            System.out.println("----- 成绩信息管理 -----");
            System.out.println("1. 增加成绩   2. 修改成绩   3. 删除成绩");
            System.out.println("4. 按学号查询 5. 按课程查询 6. 显示全部");
            System.out.println("0. 返回");
            System.out.print("请选择：");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addScoreView();
                    break;
                case "2":
                    editScoreView();
                    break;
                case "3":
                    deleteScoreView();
                    break;
                case "4":
                    queryScoreByStudentView();
                    break;
                case "5":
                    queryScoreByCourseView();
                    break;
                case "6":
                    displayScores(controller.getAllScores());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误，请重选");
            }
        }
    }

    private static void addScoreView() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine().trim();
        if (!controller.isStudentExist(id)) {
            System.out.println("该学号的学生不存在，请先添加学生信息！");
            return;
        }
        System.out.print("请输入课程名称：");
        String course = scanner.nextLine().trim();
        System.out.print("请输入成绩（0-100）：");
        double score = readDouble();
        if (score < 0 || score > 100) {
            System.out.println("成绩必须在 0-100 之间！");
            return;
        }
        if (controller.addScore(id, course, score)) {
            System.out.println("添加成绩成功！");
        } else {
            System.out.println("添加失败：该学生的这门课程成绩已存在！");
        }
    }

    private static void editScoreView() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine().trim();
        System.out.print("请输入课程名称：");
        String course = scanner.nextLine().trim();
        System.out.print("请输入新成绩（0-100）：");
        double score = readDouble();
        if (score < 0 || score > 100) {
            System.out.println("成绩必须在 0-100 之间！");
            return;
        }
        if (controller.updateScore(id, course, score)) {
            System.out.println("修改成绩成功！");
        } else {
            System.out.println("修改失败：未找到对应的成绩记录！");
        }
    }

    private static void deleteScoreView() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine().trim();
        System.out.print("请输入课程名称：");
        String course = scanner.nextLine().trim();
        if (controller.deleteScore(id, course)) {
            System.out.println("删除成绩成功！");
        } else {
            System.out.println("删除失败：未找到对应的成绩记录！");
        }
    }

    private static void queryScoreByStudentView() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine().trim();
        displayScores(controller.getScoresByStudent(id));
    }

    private static void queryScoreByCourseView() {
        System.out.print("请输入课程名称：");
        String course = scanner.nextLine().trim();
        displayScores(controller.getScoresByCourse(course));
    }

    // =====================================================================
    // 子菜单：成绩查询与统计
    // =====================================================================

    private static void queryMenu() {
        while (true) {
            System.out.println();
            System.out.println("----- 成绩查询与统计 -----");
            System.out.println("1. 按学号查询   2. 按课程查询");
            System.out.println("3. 成绩升序     4. 成绩降序");
            System.out.println("5. 分数段统计   6. 平均/最高/最低分");
            System.out.println("0. 返回");
            System.out.print("请选择：");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    queryScoreByStudentView();
                    break;
                case "2":
                    queryScoreByCourseView();
                    break;
                case "3":
                    displayScores(controller.getScoresSortedAscending());
                    break;
                case "4":
                    displayScores(controller.getScoresSortedDescending());
                    break;
                case "5":
                    displaySegmentCount(controller.getScoreSegmentCount());
                    break;
                case "6":
                    displayStatistics(controller.getAverage(), controller.getMax(), controller.getMin());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误，请重选");
            }
        }
    }

    // =====================================================================
    // 展示方法
    // =====================================================================

    /** 展示学生列表 */
    private static void displayStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        System.out.println("----- 学生列表（共 " + students.size() + " 人）-----");
        System.out.println("学号\t\t姓名\t性别\t班级\t\t年龄");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    /** 展示单个学生 */
    private static void displayStudent(Student student) {
        if (student == null) {
            System.out.println("未找到该学生！");
            return;
        }
        System.out.println("----- 学生信息 -----");
        System.out.println("学号\t\t姓名\t性别\t班级\t\t年龄");
        System.out.println(student);
    }

    /** 展示成绩列表（通过学号补全姓名） */
    private static void displayScores(List<StudentDao.Score> scores) {
        if (scores.isEmpty()) {
            System.out.println("暂无成绩信息！");
            return;
        }
        System.out.println("----- 成绩列表（共 " + scores.size() + " 条）-----");
        System.out.println("学号\t\t姓名\t课程\t\t成绩");
        for (StudentDao.Score s : scores) {
            Student stu = controller.getStudentById(s.getStudentId());
            String name = (stu == null) ? "未知" : stu.getStudentName();
            System.out.println(s.getStudentId() + "\t" + name + "\t"
                    + s.getCourseName() + "\t\t" + s.getScore());
        }
    }

    /** 展示分数段统计 */
    private static void displaySegmentCount(int[] count) {
        String[] names = {"不及格(0-59)", "及格(60-69)", "中等(70-79)", "良好(80-89)", "优秀(90-100)"};
        System.out.println("----- 分数段统计 -----");
        for (int i = 0; i < count.length; i++) {
            System.out.println(names[i] + "：" + count[i] + " 人");
        }
    }

    /** 展示平均分、最高分、最低分 */
    private static void displayStatistics(double average, double max, double min) {
        if (controller.getAllScores().isEmpty()) {
            System.out.println("暂无成绩，无法统计！");
            return;
        }
        System.out.println("----- 成绩统计 -----");
        System.out.println("平均分：" + String.format("%.2f", average));
        System.out.println("最高分：" + String.format("%.2f", max));
        System.out.println("最低分：" + String.format("%.2f", min));
    }

    // =====================================================================
    // 输入工具
    // =====================================================================

    /** 读整数，输入非数字时提示重输 */
    private static int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("输入无效，请输入一个整数：");
            }
        }
    }

    /** 读小数，输入非数字时提示重输 */
    private static double readDouble() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("输入无效，请输入一个数字：");
            }
        }
    }
}
