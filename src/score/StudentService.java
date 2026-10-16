package score;

import java.util.List;

/**
 * 5.3 StudentService.java（Service 业务逻辑层）
 *
 * 职责：处理业务规则，不直接碰界面、也不直接碰集合。
 * 例如"学号不能重复""删除学生要级联删除其成绩"都属于业务规则。
 */
public class StudentService {

    private final StudentDao studentDao = new StudentDao();

    // =====================================================================
    // 学生业务
    // =====================================================================

    /** 添加；学号已存在返回 false */
    public boolean addStudent(Student student) {
        if (studentDao.exists(student.getStudentId())) {
            return false;
        }
        studentDao.insert(student);
        return true;
    }

    /** 添加（按框架示例的四参数形式） */
    public boolean addStudent(String studentId, String studentName, String gender, String className) {
        return addStudent(new Student(studentId, studentName, gender, className));
    }

    /** 添加（完整五项，含年龄） */
    public boolean addStudent(String studentId, String studentName, String gender,
                              String className, int age) {
        return addStudent(new Student(studentId, studentName, gender, className, age));
    }

    /** 修改学生信息；学号不存在返回 false */
    public boolean updateStudent(Student student) {
        return studentDao.update(student);
    }

    /**
     * 删除学生；成功后级联删除该学生的全部成绩。
     *
     * @return 删除成功的成绩条数，删除学生失败返回 -1
     */
    public int deleteStudent(String studentId) {
        if (!studentDao.delete(studentId)) {
            return -1;
        }
        return studentDao.deleteScoreByStudentId(studentId);
    }

    /** 全部学生 */
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    /** 按学号取学生；不存在返回 null */
    public Student getStudentById(String studentId) {
        return studentDao.findById(studentId);
    }

    /** 学号是否存在 */
    public boolean isStudentExist(String studentId) {
        return studentDao.exists(studentId);
    }

    // =====================================================================
    // 成绩业务
    // =====================================================================

    /**
     * 添加成绩；学号不存在或该课程成绩已存在时返回 false。
     */
    public boolean addScore(String studentId, String courseName, double score) {
        if (!studentDao.exists(studentId)) {
            return false;
        }
        if (studentDao.findScore(studentId, courseName) != null) {
            return false;
        }
        studentDao.insertScore(new StudentDao.Score(studentId, courseName, score));
        return true;
    }

    /** 修改成绩；找不到对应成绩返回 false */
    public boolean updateScore(String studentId, String courseName, double newScore) {
        return studentDao.updateScore(studentId, courseName, newScore);
    }

    /** 删除某条成绩；找不到返回 false */
    public boolean deleteScore(String studentId, String courseName) {
        return studentDao.deleteScore(studentId, courseName);
    }

    /** 按学号查成绩列表 */
    public List<StudentDao.Score> getScoresByStudent(String studentId) {
        return studentDao.findScoreByStudentId(studentId);
    }

    /** 按课程查成绩列表 */
    public List<StudentDao.Score> getScoresByCourse(String courseName) {
        return studentDao.findScoreByCourse(courseName);
    }

    /** 全部成绩 */
    public List<StudentDao.Score> getAllScores() {
        return studentDao.findAllScores();
    }

    /** 成绩升序 */
    public List<StudentDao.Score> getScoresSortedAscending() {
        return studentDao.sortScoreAscending();
    }

    /** 成绩降序 */
    public List<StudentDao.Score> getScoresSortedDescending() {
        return studentDao.sortScoreDescending();
    }

    /** 分数段统计 */
    public int[] getScoreSegmentCount() {
        return studentDao.scoreSegmentCount();
    }

    /** 平均分 */
    public double getAverage() {
        return studentDao.average();
    }

    /** 最高分 */
    public double getMax() {
        return studentDao.max();
    }

    /** 最低分 */
    public double getMin() {
        return studentDao.min();
    }
}
