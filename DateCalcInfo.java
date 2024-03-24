import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateCalcInfo {
    
    public static int convertToJulian(String gregorianDateInput) {

        int[] monthSize = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0, finalJulian = 0;

        int month = Integer.parseInt(gregorianDateInput.substring(0, 2));
        int day = Integer.parseInt(gregorianDateInput.substring(3, 5));
        int year = Integer.parseInt(gregorianDateInput.substring(6));

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            monthSize[1] = 29;
        }
      
        for (int i = 0; i < month - 1; i++) {
            totalDays += monthSize[i];
        }
      
        finalJulian = year * 1000 + totalDays + day;
        return finalJulian;
    }
    
    public static String convertToGregorian(int julianDateInput) {

        int year = 0, day = 0, month = 1, i = 0;
        String finalGregorian, dateInput;

        int[] monthSize = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        dateInput = Integer.toString(julianDateInput);

        year = Integer.parseInt (dateInput.substring(0, 4));
        day = Integer.parseInt(dateInput.substring(4));

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            monthSize[1] = 29;
        }
        
        while (day > monthSize[i]) {
            day -= monthSize[i];
            month++;
            i++;
        }

        finalGregorian = String.format("%02d/%02d/%04d",month, day, year); 
        return finalGregorian;
    }

    public static String addSubtractDays (String gregorianDateInput, int daysAddSubtract){
        
        LocalDate dateAddSubstract;
        boolean daysChangingisNegative;
        String gregorianReturn;

        if (daysAddSubtract < 0){
            daysChangingisNegative = false;
        } else {
            daysChangingisNegative = true;
        }

        DateTimeFormatter dashedDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter gregorianDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        dateAddSubstract = LocalDate.parse(gregorianDateInput, dashedDateFormat);

        if (daysChangingisNegative = false){
            dateAddSubstract = dateAddSubstract.plusDays(daysAddSubtract);
        } else {
            daysAddSubtract = daysAddSubtract * (-1);
            dateAddSubstract = dateAddSubstract.minusDays(daysAddSubtract);
        }

        gregorianReturn = dateAddSubstract.format(gregorianDateFormat);

        return gregorianReturn;
    }

    public static String formatDateString (String gregorianDateInput){

        String humanReadableFormat, monthHumanReadable;

        String[] monthArray = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        int month = Integer.parseInt(gregorianDateInput.substring(0, 2));
        int day = Integer.parseInt(gregorianDateInput.substring(3, 5));
        int year = Integer.parseInt(gregorianDateInput.substring(6));
        
        DateTimeFormatter gregorianDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate readableDate = LocalDate.parse(gregorianDateInput, gregorianDateFormat);
        DayOfWeek dayOfWeek = readableDate.getDayOfWeek();
    
        int i = month - 1;
        monthHumanReadable = monthArray[i];

        humanReadableFormat = dayOfWeek + ", " + monthHumanReadable + " " + day + ", " + year;
        return humanReadableFormat;
    }

    public static int daysDifferent(String gregorianDateInput1, String gregorianDateInput2){

        long daysBetweenLong = 0;
        int daysBetweenInt = 0 ;

        DateTimeFormatter gregorianDateTimeFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date1 = LocalDate.parse(gregorianDateInput1, gregorianDateTimeFormat);
        LocalDate date2 = LocalDate.parse(gregorianDateInput2, gregorianDateTimeFormat);

        daysBetweenLong = ChronoUnit.DAYS.between(date1, date2);
        daysBetweenInt = Math.toIntExact(daysBetweenLong);

        return daysBetweenInt;
    }
}