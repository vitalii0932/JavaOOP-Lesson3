package BasicLevel;

import BasicLevel.Exceptions.GroupOverflowException;
import BasicLevel.Exceptions.StudentNotFoundException;

import java.util.Arrays;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void AddStudent(Student student) throws GroupOverflowException {
        for(int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = student;
                System.out.println("Student added");
                return;
            }
        }
        throw new GroupOverflowException();
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if(student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id) {
        Student[] newStudents = new Student[10];
        boolean remove = false;
        int j = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                if(students[i].getId() != id) {
                    newStudents[j] = students[i];
                    j++;
                } else {
                    remove = true;
                    continue;
                }
            }
        }
        System.arraycopy(newStudents, 0, students, 0, students.length);
        return remove;
    }

    @Override
    public String toString() {
        return "Group{" + "groupName='" + groupName + '\'' + ", students=" + Arrays.toString(students) + '}';
    }
}
