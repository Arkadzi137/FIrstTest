package Framework.Util;

import Framework.Log;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class UtilsMethods {

    public static int parseString(String str){
        str = str.replaceAll("[^0-9]", "");
        int i = Integer.parseInt(str);
        return i;
    }

    public static String randomText(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static int randomNumber(int to){
        return  (int) (Math.random()*(to+1));
    }

    public static int getNextLeapYear(){
        for (int i = LocalDate.now().getYear(); i < LocalDate.now().getYear()+4; i++) {
            if(java.time.Year.of(i).isLeap()){
                Log.info("Next leap year is "+i);
                return i;
            }
        }
        return -1;
    }

    public static int getLastLeapYear(){
        for (int i = LocalDate.now().getYear(); i > LocalDate.now().getYear()-4; i--) {
            if(java.time.Year.of(i).isLeap()){
                Log.info("Last leap year is "+i);
                return i;
            }
        }
        return -1;
    }
    public static String getDateNow(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM/dd/yyyy");
        String date = formatForDateNow.format(new Date());
        Log.info("Date now is "+date);
        return date;
    }

    public static String getDateAndTimeNow(){
        SimpleDateFormat formatForDateAndTimeNow = new SimpleDateFormat("MMMM dd, yyyy h:mm a", Locale.ENGLISH);
        String dateAndTime = formatForDateAndTimeNow.format(new Date());
        Log.info("Date and time now is "+dateAndTime);
        return dateAndTime;
    }
}
