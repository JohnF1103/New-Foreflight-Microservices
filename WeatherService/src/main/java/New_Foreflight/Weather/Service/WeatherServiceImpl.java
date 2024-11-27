package New_Foreflight.Weather.Service;

import New_Foreflight.Weather.DTO.AirportInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements Weatherservice {

    @Override
    public AirportInfoResponse getAirportInfo(String iaco) {


        return new AirportInfoResponse(ParseAirportInfo(iaco),"vfr");
    }

    @Override
    public String ParseAirportInfo(String info) {


        return "blahnlah";
    }
}
