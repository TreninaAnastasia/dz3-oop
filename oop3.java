import java.util.*;

public class oop3 {

    class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    class StudentGroup implements Comparable<StudentGroup> {
        String groupId;
        List<Student> students;

        public StudentGroup(String groupId) {
            this.groupId = groupId;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public int getStudentCount() {
            return students.size();
        }

        @Override
        public int compareTo(StudentGroup other) {
            // Сначала сравниваем по количеству студентов
            int compareCount = Integer.compare(this.getStudentCount(), other.getStudentCount());
            if (compareCount != 0)
                return compareCount;

            // Если количество студентов одинаковое, сравниваем по идентификатору группы
            return this.groupId.compareTo(other.groupId);
        }

        @Override
        public String toString() {
            return "Group ID: " + groupId + ", Students: " + students.size() + ", Members: " + students;
        }
    }

    class StudentStream implements Iterable<StudentGroup> {
        String streamNumber;
        List<StudentGroup> groups;

        public StudentStream(String streamNumber) {
            this.streamNumber = streamNumber;
            this.groups = new ArrayList<>();
        }

        public void addGroup(StudentGroup group) {
            groups.add(group);
            Collections.sort(groups); // Сортировка групп после добавления новой группы
        }

        @Override
        public Iterator<StudentGroup> iterator() {
            return groups.iterator();
        }

        @Override
        public String toString() {
            return "Stream Number: " + streamNumber + ", Groups: " + groups.size() + ", Group Details: " + groups;
        }
    }

    public class Main {
        public static void main(String[] args) {
            StudentStream stream = new StudentStream("S1");
            StudentGroup group1 = new StudentGroup("G1");
            group1.addStudent(new Student("Alice"));
            group1.addStudent(new Student("Bob"));

            StudentGroup group2 = new StudentGroup("G2");
            group2.addStudent(new Student("Charlie"));

            stream.addGroup(group1);
            stream.addGroup(group2);

            // Итерация по группам
            for (StudentGroup group : stream) {
                System.out.println(group);
            }

            // Вывод информации о потоке студентов
            System.out.println(stream);
        }
    }

}
