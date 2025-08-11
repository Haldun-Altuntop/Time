package arc.haldun.time;

public class DateTime {

    private double numericValue;

    private Date date;
    private Time time;

    /**
     * yyyy-mm-dd hh:MM:ss
     * @param string
     */
    public DateTime(String string) {

        if (string == null) {
            string = "0000-00-00 00:00:00";
        }

        String dateStr = string.split(" ")[0];
        String timeStr = string.split(" ")[1];

        this.date = new Date(
                Integer.parseInt(dateStr.split("-")[0]),
                Integer.parseInt(dateStr.split("-")[1]),
                Integer.parseInt(dateStr.split("-")[2])
        );

        this.time = new Time(
                Integer.parseInt(timeStr.split(":")[0]),
                Integer.parseInt(timeStr.split(":")[1]),
                Integer.parseInt(timeStr.split(":")[2])
        );

        calculateNumericValue();
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this.date = new Date(year, month, day);
        this.time = new Time(hour, minute, second);
        calculateNumericValue();
    }

    public DateTime(Date date, Time time) {
        this.date = date;
        this.time = time;
        calculateNumericValue();
    }

    public DateTime(double numericValue) {
        this.numericValue = numericValue;
        calculateDateTime();
    }

    public static DateTime now() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        return new DateTime(now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getHour(), now.getMinute(), now.getSecond());
    }

    private void calculateDateTime() {
        int dateNumeric = (int) numericValue;
        double timeNumeric = numericValue - dateNumeric;

        this.date = new Date(dateNumeric);
        this.time = new Time(timeNumeric);
    }

    private void calculateNumericValue() {
        this.numericValue = date.getNumericValue() + time.getNumericValue();
    }

    public double getNumericValue() {
        return numericValue;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s %s", date, time);
    }
}
