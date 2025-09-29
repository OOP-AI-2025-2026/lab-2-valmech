package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int h, int m) {
        if (h < 0 || m < 0 || m >= 60) return;
        int totalMinutes = this.minutes + m;
        this.hours += h + totalMinutes / 60;
        this.minutes = totalMinutes % 60;
        if (this.hours >= 24) this.hours %= 24;
    }

    public void addTimeSpan(TimeSpan other) {
        if (other == null) return;
        add(other.hours, other.minutes);
    }

    public void subtract(TimeSpan other) {
        if (other == null) return;
        int totalThis = this.hours * 60 + this.minutes;
        int totalOther = other.hours * 60 + other.minutes;
        int result = totalThis - totalOther;
        if (result < 0) return;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) return;
        int totalMinutes = (hours * 60 + minutes) * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }
}
