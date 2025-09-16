package ua.opnu;

public class Student {
    private String name;
    private int year;
    private String[] courses;
    private int courseCount;
    private static final int MAX_COURSES = 50;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (year < 1 || year > 4) {
            this.year = 1;
        } else {
            this.year = year;
        }

        this.courses = new String[MAX_COURSES];
        this.courseCount = 0;
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty() && courseCount < MAX_COURSES) {
            courses[courseCount] = courseName;
            courseCount++;
        }
    }

    public void dropAll() {
        for (int i = 0; i < courseCount; i++) {
            courses[i] = null;
        }
        courseCount = 0;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getTuition() {
        return year * 20000;
    }
}