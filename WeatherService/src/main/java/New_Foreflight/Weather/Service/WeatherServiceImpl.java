package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportInfoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


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

        return new AirportInfoResponse(ParseAirportInfo(icao), "vfr");
    }

    @Override
    public String ParseAirportInfo(String info) {

        info = "call";

        return "getting for " + info;
    }
}
