package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
//applying Introduce Foreign Method
public class DateFormatter {

    public static String Formatter(Date date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat( format, Locale.ENGLISH );

        return formatter.format( date );
    }

}
