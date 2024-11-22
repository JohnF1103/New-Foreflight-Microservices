package New_Foreflight.Weather.Service;

import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements Weatherservice {
    @Override
    public String getGreeting() {
        return "hello world";
    }
}
