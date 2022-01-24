package helpers;

import gui.ManageToDo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
//applying Introduce Foreign Method
public class DateConverter {


    public static LocalDateTime convertDateToLocalDateTimeViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime dateToConvert){
        return  Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

}
