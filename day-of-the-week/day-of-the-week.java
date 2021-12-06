import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String answer = "";
        try {
            String dateString = String.format("%d,%d,%d",year,month,day);
            SimpleDateFormat sdf = new SimpleDateFormat("yy,MM,dd");
            Date date = sdf.parse(dateString);
            sdf.applyPattern("EEEE");
            answer = sdf.format(date);
        }
        catch (Exception e) {
            //
            System.out.println("");
        }
        return answer;
    }
}