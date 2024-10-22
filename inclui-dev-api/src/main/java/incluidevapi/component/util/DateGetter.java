package incluidevapi.component.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateGetter {
    public static LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    public static Calendar getDateCalendar() {
        return Calendar.getInstance();
    }

    private static DateTimeFormatter formatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    public static String getDateFormatedMonthAndYear(LocalDateTime data) {
        return formatter("MM/yyyy").format(data);
    }

    public static boolean checkDate(LocalDateTime data) {
        return(
                !isBefore(data, getDate()) &&
                        isEqualMonthAndYear(data, getDate())
        );
    }

    public static boolean isBefore(LocalDateTime dateComparadora, LocalDateTime dateComparada) {
        return dateComparadora.isBefore(dateComparada);
    }

    public static boolean isEqualMonthAndYear(LocalDateTime dateComparadora, LocalDateTime dateComparada) {
        return getDateFormatedMonthAndYear(dateComparadora).equals(getDateFormatedMonthAndYear(dateComparada));
    }
}
