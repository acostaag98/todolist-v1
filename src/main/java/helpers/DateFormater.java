package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormater {

    public String Formater( Date date, String format){
        SimpleDateFormat formater = new SimpleDateFormat( format, Locale.ENGLISH );

        return formater.format( date );
    }

}
