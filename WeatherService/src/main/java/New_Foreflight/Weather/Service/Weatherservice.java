package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportWeatherResponse;

import java.util.HashMap;

public interface Weatherservice {

     AirportWeatherResponse getAirportWeather(String iaco);
     String ParseRawMETARText(String info);
     HashMap<String, Object> SeperateMetarComponents(String info);
}


