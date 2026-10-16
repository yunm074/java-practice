package score;

import java.util.List;

/**
 * 5.4 StudentController.java（Controller 控制层）
 *
 * 职责：只做"转发"，把界面的请求转给 Service，不写任何业务逻辑。
 * 这样界面层就不需要认识 Service 和 Dao，层与层之间保持解耦。
 */
public class StudentController {

    private final StudentService studentService = new StudentService();

    // =====================================================================
    // 学生
    // =====================================================================

    public boolean addStudent(Student student) {
        return studentService.addStudent(student);
    }

    /** 按框架示例的四参数形式添加 */
    public boolean addStudent(String studentId, String studentName,
                              String gender, String className) {
        return studentService.addStudent(studentId, studentName, gender, className);
    }

    /** 完整五项（含年龄）添加 */
    public boolean addStudent(String studentId, String studentName, String gender,
                              String className, int age) {
        return studentService.addStudent(studentId, studentName, gender, className, age);
    }

    public boolean updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    /** 删除学生（含级联删除成绩）；返回删除的成绩条数，失败返回 -1 */
    public int deleteStudent(String studentId) {
        return studentService.deleteStudent(studentId);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudentById(String studentId) {
        return studentService.getStudentById(studentId);
    }

    public boolean isStudentExist(String studentId) {
        return studentService.isStudentExist(studentId);
    }

    // =====================================================================
    // 成绩
    // =====================================================================

    public boolean addScore(String studentId, String courseName, double score) {
        return studentService.addScore(studentId, courseName, score);
    }

    public boolean updateScore(String studentId, String courseName, double newScore) {
        return studentService.updateScore(studentId, courseName, newScore);
    }

    public boolean deleteScore(String studentId, String courseName) {
        return studentService.deleteScore(studentId, courseName);
    }

    public List<StudentDao.Score> getScoresByStudent(String studentId) {
        return studentService.getScoresByStudent(studentId);
    }

    public List<StudentDao.Score> getScoresByCourse(String courseName) {
        return studentService.getScoresByCourse(courseName);
    }

    public List<StudentDao.Score> getAllScores() {
        return studentService.getAllScores();
    }

    public List<StudentDao.Score> getScoresSortedAscending() {
        return studentService.getScoresSortedAscending();
    }

    public List<StudentDao.Score> getScoresSortedDescending() {
        return studentService.getScoresSortedDescending();
    }

    public int[] getScoreSegmentCount() {
        return studentService.getScoreSegmentCount();
    }

    public double getAverage() {
        return studentService.getAverage();
    }

    public double getMax() {
        return studentService.getMax();
    }

    public double getMin() {
        return studentService.getMin();
    }
}
