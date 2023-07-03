package BasicLevel;

import BasicLevel.Exceptions.GroupOverflowException;
import BasicLevel.Exceptions.StudentNotFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Group group1 = new Group();
        Group group2 = new Group();

        Student[] students;

        for(int i = 1; i < 3; i++) {
            students = new Student[10];
            for(int j = 0; j < 10; j++) {
                String id = Integer.toString(i) + Integer.toString(j);
                students[j] = new Student("Name" + id, "LastName" + id, Gender.Male, Integer.parseInt(id), "Group" + String.valueOf(i));
            }
            switch (i) {
                case 1: {
                    group1.setGroupName("Group1");
                    group1.setStudents(students);
                    break;
                }
                case 2: {
                    group2.setGroupName("Group2");
                    group2.setStudents(students);
                    break;
                }
            }
        }

        System.out.println(group1.toString());
        System.out.println(group2.toString());

        Student newStudent = new Student("newStudentName", "newStudentLastName", Gender.Female, 10, "group1");
        try {
            group1.AddStudent(newStudent);
        } catch (GroupOverflowException e) {
            System.out.println("Group overflow");
        }

        System.out.printf("Student with id [%d] delete status: %b\n", 10, group1.removeStudentByID(10));
        System.out.println(group1.toString());
        System.out.printf("Student with id [%d] delete status: %b\n", 15, group1.removeStudentByID(15));
        System.out.println(group1.toString());
        System.out.printf("Student with id [%d] delete status: %b\n", 35, group1.removeStudentByID(15));
        System.out.println(group1.toString());

        try {
            group1.AddStudent(newStudent);
            System.out.println(group1.toString());
        } catch (GroupOverflowException e) {
            System.out.println("Group overflow");
        }

        try {
            System.out.println(group2.searchStudentByLastName("LastName20").toString());
            System.out.println(group2.searchStudentByLastName("LastName24").toString());
            System.out.println(group2.searchStudentByLastName("LastName14").toString());
        } catch (StudentNotFoundException e) {
            System.out.println("Student not found");
        }

    }
}