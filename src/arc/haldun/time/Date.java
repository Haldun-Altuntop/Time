package arc.haldun.time;

public class Date {

    private int numericValue;

    private int year = 1;
    private int month = 1;
    private int day = 1;

    private final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int numericValue) {
        this.numericValue = numericValue - 1;
        calculateDate();
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        calculateNumericValue();
    }

    private void calculateNumericValue() {

        int year = this.year;
        int month = this.month;
        int day = this.day;

        if (year % 4 == 0) monthDays[1] = 29;

        while (year > 1) {
            if (year % 4 == 0) numericValue += 366;
            else numericValue += 365;
            year--;
        }

        for (int i = month - 1; i > 0; i--) {
            numericValue += monthDays[i - 1];
        }

        numericValue += day;
    }

    private void calculateDate() {

        int days = numericValue;

        while (days >= 365) {

            if (year % 4 == 0) {
                if (days >= 366) {
                    days -= 366;
                    year++;
                } else {
                    break;
                }
            } else {
                days -= 365;
                year++;
            }
        }

        if (year % 4 == 0) monthDays[1] = 29;

        for (int i = 0; i < 12; i++) {

            if (days >= monthDays[i]) {
                days -= monthDays[i];
                month++;
            } else {
                break;
            }
        }

        day = (int) (days + 1);
    }

    public long getNumericValue() {
        return numericValue;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
