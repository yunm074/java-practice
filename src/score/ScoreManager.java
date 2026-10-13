package score;

import java.util.ArrayList;
import java.util.List;

/**
 * 成绩管理类：使用集合存储成绩信息，负责成绩信息的增、删、改、查及统计运算
 */
public class ScoreManager {

    /** 使用 ArrayList 集合存储所有成绩 */
    private final ArrayList<Score> scores = new ArrayList<>();

    /** 添加成绩 */
    public boolean addScore(Score score) {
        scores.add(score);
        return true;
    }

    /** 按学号 + 课程名称删除某一条成绩 */
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

    /** 按学号删除该学生的所有成绩 */
    public void deleteByStudentId(String studentId) {
        for (int i = scores.size() - 1; i >= 0; i--) {
            if (scores.get(i).getStudentId().equals(studentId)) {
                scores.remove(i);
            }
        }
    }

    /** 按学号 + 课程名称修改成绩 */
    public boolean updateScore(String studentId, String courseName, double newScore) {
        for (Score s : scores) {
            if (s.getStudentId().equals(studentId) && s.getCourseName().equals(courseName)) {
                s.setScore(newScore);
                return true;
            }
        }
        return false;
    }

    /** 按学号查询该学生的所有成绩 */
    public List<Score> queryByStudentId(String studentId) {
        List<Score> result = new ArrayList<>();
        for (Score s : scores) {
            if (s.getStudentId().equals(studentId)) {
                result.add(s);
            }
        }
        return result;
    }

    /** 按课程名称查询所有学生的该门成绩 */
    public List<Score> queryByCourse(String courseName) {
        List<Score> result = new ArrayList<>();
        for (Score s : scores) {
            if (s.getCourseName().equals(courseName)) {
                result.add(s);
            }
        }
        return result;
    }

    /** 获取所有成绩 */
    public List<Score> getAll() {
        return scores;
    }

    /** 成绩升序排序（使用冒泡排序，返回新列表，不影响原数据） */
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

    /** 成绩降序排序（使用冒泡排序，返回新列表，不影响原数据） */
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

    /** 计算所有成绩的平均分 */
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

    /** 计算所有成绩的最高分 */
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

    /** 计算所有成绩的最低分 */
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
