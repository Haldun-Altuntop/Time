import arc.haldun.time.Date;
import arc.haldun.time.DateTime;
import arc.haldun.time.Time;

public class Main {

    public static void main(String[] args) {

        //DateTime dateTime = new DateTime(2025, 3, 26, 1, 4, 31);
        DateTime now = DateTime.now();
        DateTime dateTime = new DateTime("2024-02-12 08:50:25");

        System.out.println(dateTime);
        System.out.println(dateTime.getNumericValue());

    }
}
