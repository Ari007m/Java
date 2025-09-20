import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateandTime {
    public static void main(String[] args) {
        LocalDateTime dt= LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String n =dt.format(formatter);
        System.out.println(n);
    }
}
