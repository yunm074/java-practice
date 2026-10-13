package score;

/**
 * 成绩实体类：封装某学生某门课程的成绩
 */
public class Score {

    private String studentId; // 学号
    private String courseName; // 课程名称
    private double score;      // 成绩

    /** 无参构造方法 */
    public Score() {
    }

    /** 有参构造方法 */
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
