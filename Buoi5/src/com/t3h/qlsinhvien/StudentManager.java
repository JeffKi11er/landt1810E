package com.t3h.qlsinhvien;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    private int checkExists(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Student student) {
        int exists = checkExists(student.getId());
        if (exists == -1) {
            students.add(student);
        } else {
            System.out.println("Student already exists");
        }
    }

    public void update(Student student) {
        int exists = checkExists(student.getId());
        if (exists >= 0) {
            students.set(exists, student);
            System.out.println("Update successfully");
        } else {
            System.out.println("Student not exists");
        }
    }

    public void remove(String id) {
        int exists = checkExists(id);
        if (exists >= 0) {
            students.remove(exists);
            System.out.println("Remove successfully");
        } else {
            System.out.println("Student not exists");
        }
    }

    public void sort() {
        students.sort(comparator);
    }

    private Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getScore() > o2.getScore()) {
                return -1;
            }
            return 1;
        }
    };

    public void printAllStudent() {
        for (Student s : students) {
            System.out.println("-------------");
            s.print();
        }
    }
}
