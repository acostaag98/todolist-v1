package helpers;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {


    @Test
    void formatter() {
        String expected = "Sun, 23 Jan 2022 5:11 PM";
        Date date = new Date(122,0,23,17,11);
        String format = "EEE, d MMM yyyy h:mm a";

        assertEquals(expected, DateFormatter.Formatter(date, format));
    }
}