package score;

import java.util.Scanner;

/**
 * 控制台界面类：循环展示菜单，从键盘动态获取用户选择的操作编号并分发执行
 */
public class ScoreMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentManager studentManager = new StudentManager();
    private final ScoreManager scoreManager = new ScoreManager();
    private final ScoreView view = new ScoreView();

    /** 系统入口：循环展示主菜单，输入 0 时退出系统 */
    public void start() {
        while (true) {
            showMainMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    scoreMenu();
                    break;
                case 3:
                    queryMenu();
                    break;
                case 0:
                    view.showMessage("感谢使用，再见！");
                    return;
                default:
                    view.showMessage("输入有误，请重新输入！");
            }
        }
    }

    /** 显示主菜单 */
    private void showMainMenu() {
        System.out.println();
        System.out.println("========== 学生成绩管理系统 ==========");
        System.out.println("1. 学生信息管理");
        System.out.println("2. 成绩信息管理");
        System.out.println("3. 成绩查询与统计");
        System.out.println("0. 退出系统");
        System.out.print("请输入您的选择：");
    }

    /** 学生信息管理子菜单 */
    private void studentMenu() {
        while (true) {
            System.out.println();
            System.out.println("===== 学生信息管理 =====");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查询学生（按学号）");
            System.out.println("5. 显示所有学生");
            System.out.println("0. 返回上级菜单");
            System.out.print("请输入您的选择：");
            int choice = readInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    queryStudent();
                    break;
                case 5:
                    view.showStudents(studentManager.getAll());
                    break;
                case 0:
                    return;
                default:
                    view.showMessage("输入有误，请重新输入！");
            }
        }
    }

    /** 成绩信息管理子菜单 */
    private void scoreMenu() {
        while (true) {
            System.out.println();
            System.out.println("===== 成绩信息管理 =====");
            System.out.println("1. 添加成绩");
            System.out.println("2. 删除成绩");
            System.out.println("3. 修改成绩");
            System.out.println("4. 查询成绩（按学号）");
            System.out.println("5. 查询成绩（按课程）");
            System.out.println("6. 显示所有成绩");
            System.out.println("0. 返回上级菜单");
            System.out.print("请输入您的选择：");
            int choice = readInt();
            switch (choice) {
                case 1:
                    addScore();
                    break;
                case 2:
                    deleteScore();
                    break;
                case 3:
                    updateScore();
                    break;
                case 4:
                    queryScoreByStudent();
                    break;
                case 5:
                    queryScoreByCourse();
                    break;
                case 6:
                    view.showScores(scoreManager.getAll(), studentManager);
                    break;
                case 0:
                    return;
                default:
                    view.showMessage("输入有误，请重新输入！");
            }
        }
    }

    /** 成绩查询与统计子菜单 */
    private void queryMenu() {
        while (true) {
            System.out.println();
            System.out.println("===== 成绩查询与统计 =====");
            System.out.println("1. 按学号查询成绩");
            System.out.println("2. 按课程查询成绩");
            System.out.println("3. 成绩排序（升序）");
            System.out.println("4. 成绩排序（降序）");
            System.out.println("5. 分数段统计");
            System.out.println("6. 平均分/最高分/最低分");
            System.out.println("0. 返回上级菜单");
            System.out.print("请输入您的选择：");
            int choice = readInt();
            switch (choice) {
                case 1:
                    queryScoreByStudent();
                    break;
                case 2:
                    queryScoreByCourse();
                    break;
                case 3:
                    view.showScores(scoreManager.sortAscending(), studentManager);
                    break;
                case 4:
                    view.showScores(scoreManager.sortDescending(), studentManager);
                    break;
                case 5:
                    view.showSegmentCount(scoreManager.scoreSegmentCount());
                    break;
                case 6:
                    showStatistics();
                    break;
                case 0:
                    return;
                default:
                    view.showMessage("输入有误，请重新输入！");
            }
        }
    }

    // ==================== 学生相关操作 ====================

    private void addStudent() {
        System.out.print("请输入学号：");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            view.showMessage("学号不能为空！");
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

        Student student = new Student(id, name, gender, className, age);
        if (studentManager.addStudent(student)) {
            view.showMessage("添加学生成功！");
        } else {
            view.showMessage("添加失败：该学号已存在！");
        }
    }

    private void deleteStudent() {
        System.out.print("请输入要删除的学生学号：");
        String id = scanner.nextLine().trim();
        if (studentManager.deleteStudent(id)) {
            scoreManager.deleteByStudentId(id);
            view.showMessage("删除学生成功，该学生的成绩已一并删除！");
        } else {
            view.showMessage("删除失败：未找到该学号的学生！");
        }
    }

    private void updateStudent() {
        System.out.print("请输入要修改的学生学号：");
        String id = scanner.nextLine().trim();
        if (studentManager.findById(id) == null) {
            view.showMessage("未找到该学号的学生！");
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
        if (studentManager.updateStudent(student)) {
            view.showMessage("修改学生信息成功！");
        } else {
            view.showMessage("修改失败！");
        }
    }

    private void queryStudent() {
        System.out.print("请输入要查询的学生学号：");
        String id = scanner.nextLine().trim();
        view.showStudent(studentManager.findById(id));
    }

    // ==================== 成绩相关操作 ====================

    private void addScore() {
        System.out.print("请输入学号：");
        String studentId = scanner.nextLine().trim();
        if (studentManager.findById(studentId) == null) {
            view.showMessage("该学号的学生不存在，请先添加学生信息！");
            return;
        }
        System.out.print("请输入课程名称：");
        String courseName = scanner.nextLine().trim();
        System.out.print("请输入成绩（0-100）：");
        double score = readDouble();
        if (score < 0 || score > 100) {
            view.showMessage("成绩必须在 0-100 之间！");
            return;
        }
        if (scoreManager.addScore(new Score(studentId, courseName, score))) {
            view.showMessage("添加成绩成功！");
        } else {
            view.showMessage("添加成绩失败！");
        }
    }

    private void deleteScore() {
        System.out.print("请输入学号：");
        String studentId = scanner.nextLine().trim();
        System.out.print("请输入课程名称：");
        String courseName = scanner.nextLine().trim();
        if (scoreManager.deleteScore(studentId, courseName)) {
            view.showMessage("删除成绩成功！");
        } else {
            view.showMessage("删除失败：未找到对应的成绩记录！");
        }
    }

    private void updateScore() {
        System.out.print("请输入学号：");
        String studentId = scanner.nextLine().trim();
        System.out.print("请输入课程名称：");
        String courseName = scanner.nextLine().trim();
        System.out.print("请输入新成绩（0-100）：");
        double newScore = readDouble();
        if (newScore < 0 || newScore > 100) {
            view.showMessage("成绩必须在 0-100 之间！");
            return;
        }
        if (scoreManager.updateScore(studentId, courseName, newScore)) {
            view.showMessage("修改成绩成功！");
        } else {
            view.showMessage("修改失败：未找到对应的成绩记录！");
        }
    }

    private void queryScoreByStudent() {
        System.out.print("请输入学号：");
        String studentId = scanner.nextLine().trim();
        view.showScores(scoreManager.queryByStudentId(studentId), studentManager);
    }

    private void queryScoreByCourse() {
        System.out.print("请输入课程名称：");
        String courseName = scanner.nextLine().trim();
        view.showScores(scoreManager.queryByCourse(courseName), studentManager);
    }

    private void showStatistics() {
        if (scoreManager.getAll().isEmpty()) {
            view.showMessage("暂无成绩，无法统计！");
            return;
        }
        view.showStatistics(scoreManager.average(), scoreManager.max(), scoreManager.min());
    }

    // ==================== 输入工具方法 ====================

    /** 读取一个整数，输入非数字时提示重新输入 */
    private int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("输入无效，请输入一个整数：");
            }
        }
    }

    /** 读取一个小数，输入非数字时提示重新输入 */
    private double readDouble() {
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
