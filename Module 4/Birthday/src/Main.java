import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        int day = 31;
        int month = 12;
        int year = 1990;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEEE ");

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, month -1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);

        Calendar date = Calendar.getInstance();
        if (calendar.after(date)) {
            System.out.println("Введенная дата не наступила!");
        } else {
            for (int i = 0; i < date.getWeekYear() - year; i++) {
                System.out.println(i + " - " + dateFormat.format(calendar.getTime()));
                calendar.add(Calendar.YEAR, 1);
            }
        }
    }
}