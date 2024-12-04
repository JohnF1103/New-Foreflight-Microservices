package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportInfoResponse;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class WeatherServiceImpl implements Weatherservice {

    @Value("${checkwx.api.url}")
    private String apiUrl;

    @Value("${checkwx.api.key}")
    private String apiKey;

    @Override
    public AirportInfoResponse getAirportInfo(String icao) {

        String endpoint = apiUrl.replace("{station}", icao) + "?x-api-key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(endpoint, String.class);
    

        return new AirportInfoResponse(ParseAirportInfo(result), "vfr");
    }

    @Override
    public String ParseAirportInfo(String info) {

        
        
        JSONObject json = new JSONObject(info);

        Object result = json.getJSONArray("data").getJSONObject(0).get("raw_text");

        System.out.println(result.toString());
        return "getting for ";
        
    }
}
