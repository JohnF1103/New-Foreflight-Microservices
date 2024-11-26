package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements Weatherservice {
    @Override
    public String getGreeting() {
        return "hello world";
    }

    @Override
    public AirportInfoResponse getAirportInfo(String iaco) {

        return null;
    }
}
