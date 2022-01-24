package helpers;

import helpers.DateConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class DateConverterTest {

    @Test
    void convertDateToLocalDateTimeViaMilisecond() {
        LocalDateTime expected = LocalDateTime.of(2022,1,25,11,04);
        Date actual = new Date(122,0,25,11,04);
        assertEquals(expected, DateConverter.convertDateToLocalDateTimeViaMilisecond(actual));
    }

    @Test
    void convertLocalDateTimeToDate() {
        Date expected = new Date(122,0,25,11,04);
        LocalDateTime actual = LocalDateTime.of(2022,1,25,11,04);
        assertEquals(expected, DateConverter.convertLocalDateTimeToDate(actual) );
    }
}