package ua.opnu;


public class TimeSpan {
    private int hours;
    private int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return; // ігноруємо неправильні аргументи
        }
        int totalMinutes = getTotalMinutes() + (hours * 60 + minutes);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        int totalCurrent = getTotalMinutes();
        int totalOther = span.getTotalMinutes();

        if (totalOther > totalCurrent) {
            return; // нічого не змінюємо
        }

        int result = totalCurrent - totalOther;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            return; // ігноруємо
        }
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }
}