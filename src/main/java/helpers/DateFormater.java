package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

    public String Formater( Date date, String format){
        SimpleDateFormat formater = new SimpleDateFormat( format );

        return formater.format( date );
    }

}
