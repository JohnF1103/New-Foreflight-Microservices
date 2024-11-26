package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportInfoResponse;

public interface Weatherservice {
     String getGreeting();

     AirportInfoResponse getAirportInfo(String iaco);
}
