package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    public String Formatter(Date date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat( format, Locale.ENGLISH );

        return formatter.format( date );
    }

}
