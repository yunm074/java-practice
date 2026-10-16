package score;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.2 StudentDao.java（DAO 数据访问层）
 *
 * 职责：只管"数据怎么存、怎么取"，不含任何输入输出和业务判断。
 * 用 ArrayList 做内存存储，方法命名对齐《代码框架》文档。
 *
 * 说明：因框架要求共 5 个文件，故把成绩实体 Score 作为本类的静态内部类，
 *      与成绩数据的存取放在同一文件内（同属数据层）。
 */
public class StudentDao {

    /** 学生数据表 */
    private final List<Student> students = new ArrayList<>();

    /** 成绩数据表 */
    private final List<Score> scores = new ArrayList<>();

    // =====================================================================
    // 内部类：成绩实体
    // =====================================================================

    /**
     * 成绩实体类：记录某学生某门课程的成绩。
     * 作为内部类放在 DAO 中，保证整体仍是 5 个文件。
     */
    public static class Score {

        private String studentId;   // 学号
        private String courseName;  // 课程名称
        private double score;       // 成绩

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
            return studentId + "\t" + courseName + "\t" + score;
        }
    }

    // =====================================================================
    // 学生数据操作
    // =====================================================================

    /** 新增学生 */
    public void insert(Student student) {
        students.add(student);
    }

    /** 按学号删除学生；成功 true，失败 false */
    public boolean delete(String studentId) {
        Student s = findById(studentId);
        if (s == null) {
            return false;
        }
        return students.remove(s);
    }

    /** 按学号更新学生；成功 true，失败 false */
    public boolean update(Student student) {
        Student old = findById(student.getStudentId());
        if (old == null) {
            return false;
        }
        old.setStudentName(student.getStudentName());
        old.setGender(student.getGender());
        old.setClassName(student.getClassName());
        old.setAge(student.getAge());
        return true;
    }

    /** 查询全部学生 */
    public List<Student> findAll() {
        return students;
    }

    /** 按学号查询学生；找不到返回 null */
    public Student findById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    /** 学号是否已存在 */
    public boolean exists(String studentId) {
        return findById(studentId) != null;
    }

    // =====================================================================
    // 成绩数据操作
    // =====================================================================

    /** 新增一条成绩 */
    public void insertScore(Score score) {
        scores.add(score);
    }

    /** 按学号 + 课程删除某条成绩；成功 true，失败 false */
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

    /** 按学号删除该学生的全部成绩（删除学生时级联调用） */
    public int deleteScoreByStudentId(String studentId) {
        int removed = 0;
        for (int i = scores.size() - 1; i >= 0; i--) {
            if (scores.get(i).getStudentId().equals(studentId)) {
                scores.remove(i);
                removed++;
            }
        }
        return removed;
    }

    /** 按学号 + 课程修改成绩；成功 true，失败 false */
    public boolean updateScore(String studentId, String courseName, double newScore) {
        Score s = findScore(studentId, courseName);
        if (s == null) {
            return false;
        }
        s.setScore(newScore);
        return true;
    }

    /** 查某学生某门课的成绩；找不到返回 null */
    public Score findScore(String studentId, String courseName) {
        for (Score s : scores) {
            if (s.getStudentId().equals(studentId) && s.getCourseName().equals(courseName)) {
                return s;
            }
        }
        return null;
    }

    /** 按学号查该学生的全部成绩 */
    public List<Score> findScoreByStudentId(String studentId) {
        List<Score> result = new ArrayList<>();
        for (Score s : scores) {
            if (s.getStudentId().equals(studentId)) {
                result.add(s);
            }
        }
        return result;
    }

    /** 按课程查全部学生的该门成绩 */
    public List<Score> findScoreByCourse(String courseName) {
        List<Score> result = new ArrayList<>();
        for (Score s : scores) {
            if (s.getCourseName().equals(courseName)) {
                result.add(s);
            }
        }
        return result;
    }

    /** 全部成绩 */
    public List<Score> findAllScores() {
        return scores;
    }

    /** 成绩升序排序（冒泡排序，返回新列表，不影响原数据） */
    public List<Score> sortScoreAscending() {
        List<Score> list = new ArrayList<>(scores);
        bubbleSort(list, true);
        return list;
    }

    /** 成绩降序排序（冒泡排序，返回新列表，不影响原数据） */
    public List<Score> sortScoreDescending() {
        List<Score> list = new ArrayList<>(scores);
        bubbleSort(list, false);
        return list;
    }

    private void bubbleSort(List<Score> list, boolean asc) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                double a = list.get(j).getScore();
                double b = list.get(j + 1).getScore();
                boolean needSwap = asc ? (a > b) : (a < b);
                if (needSwap) {
                    Score temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    /** 分数段统计：0-59 / 60-69 / 70-79 / 80-89 / 90-100 */
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

    /** 全部成绩的平均分 */
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

    /** 全部成绩的最高分 */
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

    /** 全部成绩的最低分 */
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
