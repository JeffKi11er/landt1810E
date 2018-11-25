package com.t3h.qlsinhvien;

public class Student {
    private String id;
    private String name;
    private int age;
    private boolean sex;
    private float score;

    public Student(String id, String name, int age, boolean sex, float score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
        System.out.println("Sex: " + (sex ? "Male" : "Female"));
    }

    public String getId() {
        return id;
    }

    public float getScore() {
        return score;
    }
}
