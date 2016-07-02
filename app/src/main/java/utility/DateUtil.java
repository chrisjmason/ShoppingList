package utility;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(new Date());
        return date;
    }

    public static Long getTimestamp(){
        return new Date().getTime();
    }

    public static String getDifference(String thenDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date thenDateObj;

        try {
            thenDateObj = sdf.parse(thenDate);
        }catch(ParseException e){
            e.printStackTrace();
            return null;
        }

        Date nowDateObj = new Date();

        return calcDiff(nowDateObj, thenDateObj);
    }

    private static String calcDiff(Date nowDateObj, Date thenDateObj){
        long differenceMinutes = TimeUnit.MILLISECONDS.toMinutes(nowDateObj.getTime() - thenDateObj.getTime());

        long differenceHours = TimeUnit.MILLISECONDS.toHours(nowDateObj.getTime() - thenDateObj.getTime());

        long differenceDays =  TimeUnit.MILLISECONDS.toDays(nowDateObj.getTime() - thenDateObj.getTime());

        if(differenceDays ==0 && differenceHours ==0){
            return String.valueOf(differenceMinutes) + "m";
        }else if(differenceDays == 0){
            return String.valueOf(differenceHours) + "h";
        }

        return String.valueOf(differenceDays) + "d";

    }
}
