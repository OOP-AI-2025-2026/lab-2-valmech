package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private List<String> courses;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я студента не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            courses.add(courseName);
        } else {
            System.out.println("Назва дисципліни не може бути порожньою");
        }
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return name;
    }

    public int getTuition() {
        return year * 20000;
    }

    public int getYear() {
        return year;
    }

    public static void main(String[] args) {
        Student student = new Student("Ольга", 2);

        student.addCourse("Теорія ймовірності");
        student.addCourse("Організація баз даних та знань");
        student.addCourse("Об'єктно-орієнтовне програмування");

        System.out.println(student.getName() + ": кількість дисциплін - " + student.getCourseCount());

        System.out.println(student.getName() + ": рік навчання - " + student.getYear());

        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}