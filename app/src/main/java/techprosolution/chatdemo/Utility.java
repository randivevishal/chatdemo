package techprosolution.chatdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by vishalrandive on 08/03/17.
 */

public class Utility
{
    public static String getTime(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return df.format(c.getTime());
    }
}
