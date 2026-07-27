import java.util.Map;
import java.util.HashMap;

class Solution {
    private static final Map<String, String> MONTHS = new HashMap<>() {{
        put("Jan", "01"); put("Feb", "02"); put("Mar", "03"); put("Apr", "04");
        put("May", "05"); put("Jun", "06"); put("Jul", "07"); put("Aug", "08");
        put("Sep", "09"); put("Oct", "10"); put("Nov", "11"); put("Dec", "12");
    }};

    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String dayStr = parts[0].substring(0, parts[0].length() - 2);
        String month = MONTHS.get(parts[1]);
        String year = parts[2];
        String day = dayStr.length() == 1 ? "0" + dayStr : dayStr;

        return year + "-" + month + "-" + day;
    }
}
