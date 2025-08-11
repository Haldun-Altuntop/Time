package arc.haldun.time;

public class Time {

    public static final double MAX_VALUE = 1.0;

    private final int secondsInDay = 24 * 60 * 60;

    private double numericValue;

    private int hour, minute, second;

    public Time(double numericValue) {

        if (numericValue > 1.0f) throw new RuntimeException("Numeric value cannot be greater than 1");

        this.numericValue = numericValue;
        calculateTime();
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        calculateNumericValue();

        if (numericValue > 1.0f) throw new RuntimeException("Values cannot be greater than 24 hour");
    }

    private void calculateTime() {

        second = (int) (numericValue * secondsInDay);

        hour = second / (60 * 60);

        second = second % (60*60);

        minute = second / 60;

        second = second % 60;
    }

    private void calculateNumericValue() {

        numericValue += hour * 60 * 60;
        numericValue += minute * 60;
        numericValue += second;
        numericValue /= secondsInDay;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public double getNumericValue() {
        return numericValue;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
