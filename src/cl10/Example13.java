package cl10;
import java.util.*;
    class Student implements Comparable {
        private String name;
        int age;

        public Student(String name, int age) {
            this.age = age;
            this.name = name;

        }

        public String toString() {
            return name + "=" + age;
        }

        public int compareTo(Object obj) {
            Student s = (Student) obj;
            if (this.age - s.age > 0) {
                return 1;
            }
            if (this.age - s.age == 0) {
                return this.name.compareTo(s.name);
            }
            return -1;
        }
    }
        public class Example13 {


}
