package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportInfoResponse;

public interface Weatherservice {

     AirportInfoResponse getAirportInfo(String iaco);
     String ParseAirportInfo(String info);

}


