package score;

import java.util.List;

/**
 * 视图层：负责数据的展示、格式化与统计结果的呈现
 */
public class ScoreView {

    /** 显示单个学生信息 */
    public void showStudent(Student student) {
        if (student == null) {
            showMessage("未找到该学生！");
            return;
        }
        System.out.println("----- 学生信息 -----");
        System.out.println(student);
    }

    /** 显示学生列表 */
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

    /** 显示成绩列表，并通过学生管理类补全学生姓名 */
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

    /** 显示分数段统计结果 */
    public void showSegmentCount(int[] count) {
        String[] segmentNames = {"不及格(0-59)", "及格(60-69)", "中等(70-79)", "良好(80-89)", "优秀(90-100)"};
        System.out.println("----- 分数段统计 -----");
        for (int i = 0; i < count.length; i++) {
            System.out.println(segmentNames[i] + "：" + count[i] + " 人");
        }
    }

    /** 显示平均分、最高分、最低分 */
    public void showStatistics(double average, double max, double min) {
        System.out.println("----- 成绩统计 -----");
        System.out.println("平均分：" + String.format("%.2f", average));
        System.out.println("最高分：" + String.format("%.2f", max));
        System.out.println("最低分：" + String.format("%.2f", min));
    }

    /** 显示一条提示信息 */
    public void showMessage(String message) {
        System.out.println(message);
    }
}
