package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportWeatherResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.event.KeyListener;
import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;

@Service
public class WeatherServiceImpl implements Weatherservice {

    @Value("${checkwx.api.url}")
    private String apiUrl;

    @Value("${checkwx.api.key}")
    private String apiKey;

    @Override
    public AirportWeatherResponse getAirportWeather(String icao) {

        String endpoint = apiUrl.replace("{station}", icao) + "?x-api-key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        String apiResponseJSON = restTemplate.getForObject(endpoint, String.class);


        return new AirportWeatherResponse(ParseRawMETARText(apiResponseJSON), GetReadableElements(apiResponseJSON), "vfr");

    }

    @Override
    public String ParseRawMETARText(String apiResponse) {

        JSONObject json = new JSONObject(apiResponse);
        Object result = json.getJSONArray("data").getJSONObject(0).get("raw_text");
        return result.toString();
    }

    @Override
    public HashMap<String, String> GetReadableElements(String info) {


        JSONObject json = new JSONObject(info);
        JSONObject result = json.getJSONArray("data").getJSONObject(0);

        HashMap<String, String> readableElements = new HashMap<>();


        String[] keyList = {
                "observed",
                "wind",
                "visibility",
                "clouds",
                "temperature",
                "dewpoint",
                "barometer",
                "humidity"
        };

        for (String key : keyList) {
            if (key.equals("cloud_info")) {
                // Extract and print only the "text" field for cloud_info
                JSONObject cloudInfo = result.optJSONObject("cloud_info");
                if (cloudInfo != null) {
                    String cloudText = cloudInfo.optString("text", "Not Available");
                    System.out.println("Cloud info: " + cloudText);
                } else {
                    System.out.println("Cloud info: Not Available");
                }
            } else {
                // For other fields, print the value as usual
                String value = result.optString(key, "Not Available");
                System.out.println(key.replace("_", " ") + ": " + value);
            }
        }
            return null;
    }
}
