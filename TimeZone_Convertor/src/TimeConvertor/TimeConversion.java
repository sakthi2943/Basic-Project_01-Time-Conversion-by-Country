package TimeConvertor;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeConversion {


    public static String timeZone(String DateTime, String Country) throws ParseException {
        //Time
        DateTime = DateTime.trim();
        LocalDateTime localDateTime = LocalDateTime.parse(DateTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        //source zoneID
        String sourceTimeZoneId = "Asia/Kolkata";
        ZoneId sourceZone = ZoneId.of(sourceTimeZoneId);
        
        //zoneId
        String targetTimeZoneId = getSelectTimeZone(Country);
        ZoneId targetZone = ZoneId.of(targetTimeZoneId);

        //Convertion
        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(sourceZone);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZone);

        //Display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String convertedDateTime = targetZonedDateTime.format(formatter);
        
        return convertedDateTime+" "+ targetZone;
    }

    //Getting Timezone based on country selected
    private static String getSelectTimeZone(String selectTimeZone) {
        switch (selectTimeZone) {
            case "Alaska":
                return "US/Alaska";
            case "Arizona":
                return "US/Arizona";
            case "Bermuda" :
                return "Atlantic/Bermuda";
            case "Bangkok":
                return "Asia/Bangkok";
            case "Canada":
                return "Canada/Central";
            case "Chicago":
                return "America/Chicago";
            case "Dubai":
                return "Asia/Dubai";
            case "Hawaii":
                return "US/Hawaii";
            case "Hong_Kong":
                return "Asia/Hong_Kong";
            case "Iceland":
                return "Iceland";
            case "Iran" :
                return "Iran";
            case "Israel":
                return "Israel";
            case "London":
                return "Europe/London";
            case "Japan":
                return "Japan";
            case "Poland":
                return "Poland";
            case "Los_Angeles":
                return "America/Los_Angeles";
            case "Mexico_City":
                return "America/Mexico_City";
            case "New_York":
                return "America/New_York";
            case "Phoenix":
                return "America/Phoenix";
            case "Seoul":
                return "Asia/Seoul";
            case "Singapore":
                return "Singapore";
            case "South_Pole":
                return "Antarctica/South_Pole";
            case "Turkey":
                return "Turkey";
            case "Victoria":
                return "Australia/Victoria";
            default:
                break;
        }
        return "Asia/Kolkata";
    }

}
