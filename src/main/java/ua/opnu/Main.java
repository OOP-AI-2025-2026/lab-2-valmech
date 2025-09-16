package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Vlad", 2);
        s.addCourse("Math");
        s.addCourse("Programming");
        s.addCourse("History");

        System.out.println(s.getName() + ": кількість вивчаємих дисциплін - " + s.getCourseCount());
        System.out.println(s.getName() + ": рік навчання - " + s.getYear());
        System.out.println(s.getName() + ": заплатив за навчання - " + s.getTuition());
    }
}