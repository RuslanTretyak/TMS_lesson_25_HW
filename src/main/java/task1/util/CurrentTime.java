package task1.util;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CurrentTime {
    private static Map<String, String> timeZones;

    public CurrentTime() {
        if (timeZones == null) {
            timeZones = new HashMap<>();
            timeZones.put("minsk", "Europe/Minsk");
            timeZones.put("beijing", "Asia/Shanghai");
            timeZones.put("washington", "America/New_York");
        }
    }

    public String getCurrentTime(String city) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.now(ZoneId.of(timeZones.get(city))).format(dateTimeFormatter);
    }

    public Set<String> getTimeZonesKeys() {
        return timeZones.keySet();
    }
}
