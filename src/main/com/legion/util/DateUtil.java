package legion.util;
import  java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class DateUtil {

    public static long getDaySub(String beginDateStr,String endDateStr)
    {
        long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate;
        Date endDate;
        try
        {
            beginDate = format.parse(beginDateStr);
            endDate= format.parse(endDateStr);
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
        } catch (ParseException e)
        {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return day;
    }

    //Date startday = new Date();
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //String cday = sdf.format(startday);
    //long day = DateUtil.getDaySub("2019-05-25","2019-06-10");
    //System.out.print(day);
}
