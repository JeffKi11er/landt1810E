package com.t3h.qlsinhvien;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        System.out.println("==========Add========");
        manager.add(new Student(
                "1234",
                "Nguyen Van A",
                12,
                true,
                5.4f));
        manager.add(new Student(
                "1235",
                "Nguyen Thi B",
                12,
                false,
                6.3f));
        manager.add(new Student(
                "1236",
                "Nguyen Van D",
                14,
                true,
                2.4f));
        manager.printAllStudent();
        System.out.println("==========Update========");
        manager.update(new Student("1236",
                "Nguyen Van E",
                14,
                true,
                2.4f));
        manager.printAllStudent();
        System.out.println("==========Sort========");
        manager.sort();
        manager.printAllStudent();
    }
}
