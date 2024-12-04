package New_Foreflight.Weather.Service;

import org.json.JSONObject;

import New_Foreflight.Weather.DTO.AirportWeatherResponse;

public interface Weatherservice {

     AirportWeatherResponse getAirportWeather(String iaco);
     String ParseRawMETARText(String info);
     String GetReadableElements(JSONObject info);
}


