package score;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生管理类：使用集合存储学生信息，负责学生信息的增、删、改、查
 */
public class StudentManager {

    /** 使用 ArrayList 集合存储所有学生 */
    private final ArrayList<Student> students = new ArrayList<>();

    /** 添加学生，学号重复时返回 false */
    public boolean addStudent(Student student) {
        if (findById(student.getId()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    /** 按学号删除学生 */
    public boolean deleteStudent(String id) {
        Student student = findById(id);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }

    /** 按学号修改学生信息 */
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

    /** 按学号查询学生 */
    public Student findById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /** 获取所有学生 */
    public List<Student> getAll() {
        return students;
    }
}
