import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentScoreSystem {

    public static void main(String[] args) {
        ScoreMenu menu = new ScoreMenu();
        menu.start();
    }


    static class Student {
        private String id;        // 学号
        private String name;      // 姓名
        private String gender;    // 性别
        private String className; // 班级
        private int age;          // 年龄

        public Student() {
        }

        public Student(String id, String name, String gender, String className, int age) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.className = className;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "学号=" + id + "，姓名=" + name + "，性别=" + gender
                    + "，班级=" + className + "，年龄=" + age;
        }
    }

    /** 成绩实体类：封装某学生某门课程的成绩 */
    static class Score {
        private String studentId; // 学号
        private String courseName; // 课程名称
        private double score;      // 成绩

        public Score() {
        }

        public Score(String studentId, String courseName, double score) {
            this.studentId = studentId;
            this.courseName = courseName;
            this.score = score;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "学号=" + studentId + "，课程=" + courseName + "，成绩=" + score;
        }
    }


    /** 学生管理类：使用集合存储学生信息，负责学生信息的增、删、改、查 */
    static class StudentManager {
        private final ArrayList<Student> students = new ArrayList<>();

        public boolean addStudent(Student student) {
            if (findById(student.getId()) != null) {
                return false;
            }
            students.add(student);
            return true;
        }

        public boolean deleteStudent(String id) {
            Student student = findById(id);
            if (student == null) {
                return false;
            }
            students.remove(student);
            return true;
        }

        public boolean updateStudent(Student student) {
            Student old = findById(student.getId());
            if (old == null) {
                return false;
            }
            old.setName(student.getName());
            old.setGender(student.getGender());
            old.setClassName(student.getClassName());
            old.setAge(student.getAge());
            return true;
        }

        public Student findById(String id) {
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    return student;
                }
            }
            return null;
        }

        public List<Student> getAll() {
            return students;
        }
    }

    /** 成绩管理类：使用集合存储成绩信息，负责成绩信息的增、删、改、查及统计运算 */
    static class ScoreManager {
        private final ArrayList<Score> scores = new ArrayList<>();

        public boolean addScore(Score score) {
            scores.add(score);
            return true;
        }

        public boolean deleteScore(String studentId, String courseName) {
            for (int i = 0; i < scores.size(); i++) {
                Score s = scores.get(i);
                if (s.getStudentId().equals(studentId) && s.getCourseName().equals(courseName)) {
                    scores.remove(i);
                    return true;
                }
            }
            return false;
        }

        public void deleteByStudentId(String studentId) {
            for (int i = scores.size() - 1; i >= 0; i--) {
                if (scores.get(i).getStudentId().equals(studentId)) {
                    scores.remove(i);
                }
            }
        }

        public boolean updateScore(String studentId, String courseName, double newScore) {
            for (Score s : scores) {
                if (s.getStudentId().equals(studentId) && s.getCourseName().equals(courseName)) {
                    s.setScore(newScore);
                    return true;
                }
            }
            return false;
        }

        public List<Score> queryByStudentId(String studentId) {
            List<Score> result = new ArrayList<>();
            for (Score s : scores) {
                if (s.getStudentId().equals(studentId)) {
                    result.add(s);
                }
            }
            return result;
        }

        public List<Score> queryByCourse(String courseName) {
            List<Score> result = new ArrayList<>();
            for (Score s : scores) {
                if (s.getCourseName().equals(courseName)) {
                    result.add(s);
                }
            }
            return result;
        }

        public List<Score> getAll() {
            return scores;
        }

        /** 成绩升序排序（冒泡排序，返回新列表，不影响原数据） */
        public List<Score> sortAscending() {
            List<Score> list = new ArrayList<>(scores);
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.size() - 1 - i; j++) {
                    if (list.get(j).getScore() > list.get(j + 1).getScore()) {
                        Score temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
            return list;
        }

        /** 成绩降序排序（冒泡排序，返回新列表，不影响原数据） */
        public List<Score> sortDescending() {
            List<Score> list = new ArrayList<>(scores);
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.size() - 1 - i; j++) {
                    if (list.get(j).getScore() < list.get(j + 1).getScore()) {
                        Score temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
            return list;
        }

        /** 分数段统计：返回各分数段人数（0-59、60-69、70-79、80-89、90-100） */
        public int[] scoreSegmentCount() {
            int[] count = new int[5];
            for (Score s : scores) {
                double sc = s.getScore();
                if (sc < 60) {
                    count[0]++;
                } else if (sc < 70) {
                    count[1]++;
                } else if (sc < 80) {
                    count[2]++;
                } else if (sc < 90) {
                    count[3]++;
                } else {
                    count[4]++;
                }
            }
            return count;
        }

        public double average() {
            if (scores.isEmpty()) {
                return 0;
            }
            double sum = 0;
            for (Score s : scores) {
                sum += s.getScore();
            }
            return sum / scores.size();
        }

        public double max() {
            if (scores.isEmpty()) {
                return 0;
            }
            double max = scores.get(0).getScore();
            for (Score s : scores) {
                if (s.getScore() > max) {
                    max = s.getScore();
                }
            }
            return max;
        }

        public double min() {
            if (scores.isEmpty()) {
                return 0;
            }
            double min = scores.get(0).getScore();
            for (Score s : scores) {
                if (s.getScore() < min) {
                    min = s.getScore();
                }
            }
            return min;
        }
    }


    /** 视图层：负责数据的展示、格式化与统计结果的呈现 */
    static class ScoreView {

        public void showStudent(Student student) {
            if (student == null) {
                showMessage("未找到该学生！");
                return;
            }
            System.out.println("----- 学生信息 -----");
            System.out.println(student);
        }

        public void showStudents(List<Student> list) {
            if (list.isEmpty()) {
                showMessage("暂无学生信息！");
                return;
            }
            System.out.println("----- 学生列表（共 " + list.size() + " 人）-----");
            for (Student student : list) {
                System.out.println(student);
            }
        }

        public void showScores(List<Score> list, StudentManager studentManager) {
            if (list.isEmpty()) {
                showMessage("暂无成绩信息！");
                return;
            }
            System.out.println("----- 成绩列表（共 " + list.size() + " 条）-----");
            for (Score s : list) {
                Student student = studentManager.findById(s.getStudentId());
                String name = (student == null) ? "未知" : student.getName();
                System.out.println("学号=" + s.getStudentId() + "，姓名=" + name
                        + "，课程=" + s.getCourseName() + "，成绩=" + s.getScore());
            }
        }

        public void showSegmentCount(int[] count) {
            String[] segmentNames = {"不及格(0-59)", "及格(60-69)", "中等(70-79)", "良好(80-89)", "优秀(90-100)"};
            System.out.println("----- 分数段统计 -----");
            for (int i = 0; i < count.length; i++) {
                System.out.println(segmentNames[i] + "：" + count[i] + " 人");
            }
        }

        public void showStatistics(double average, double max, double min) {
            System.out.println("----- 成绩统计 -----");
            System.out.println("平均分：" + String.format("%.2f", average));
            System.out.println("最高分：" + String.format("%.2f", max));
            System.out.println("最低分：" + String.format("%.2f", min));
        }

        public void showMessage(String message) {
            System.out.println(message);
        }
    }


    /** 控制台界面类：循环展示菜单，从键盘动态获取用户选择的操作编号并分发执行 */
    static class ScoreMenu {
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

        private void showMainMenu() {
            System.out.println();
            System.out.println("========== 学生成绩管理系统 ==========");
            System.out.println("1. 学生信息管理");
            System.out.println("2. 成绩信息管理");
            System.out.println("3. 成绩查询与统计");
            System.out.println("0. 退出系统");
            System.out.print("请输入您的选择：");
        }

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

        // ---- 成绩相关操作 ----

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
}
