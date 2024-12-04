package New_Foreflight.Weather.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import New_Foreflight.Weather.DTO.AirportWeatherResponse;

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
    

        return new AirportWeatherResponse(ParseRawMETARText(apiResponseJSON), "vfr");
    }

    @Override
    public String ParseRawMETARText(String apiResponse) {

        
        
        JSONObject json = new JSONObject(apiResponse);

        Object result = json.getJSONArray("data").getJSONObject(0).get("raw_text");

        System.out.println(result);
        return result.toString();
        
    }

    @Override
    public String GetReadableElements(JSONObject info) {

        /*TODO
         * 
         * This should return certian elements of the METAR in dictionary form.
         * TIME of the report
         * Wind speed & direction 
         * Visibility
         * Cloud info
         * Tempature
         * Dewpoint
         * Altimiter setting *(in Hg)
         * humidity 
         * 
         * Feel free to make a list of these keys hard coded. 
         * 
         * add their respective values to a new dictionary and return it. 
         * 
         * OR modify the input dictionary to contain only the keys required and return it. (more space efficient) 
         * 
         * MODIFY the function header to suppourt whichever data structure you choose to use. if you wish to represent the values as strings or lists thats up to you.
        */

        
        
        return null;
        
    }
}
