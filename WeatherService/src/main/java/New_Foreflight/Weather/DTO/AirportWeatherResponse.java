package New_Foreflight.Weather.DTO;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AirportWeatherResponse {
    private String metarData;
    private HashMap<String, Object> METARcomponents;
    private String flightRules;

    public AirportWeatherResponse(String metarData, HashMap<String,Object> metarcomponents, String flightRules) {
        this.metarData = metarData;
        this.METARcomponents = metarcomponents;
        this.flightRules = flightRules;
    }

    // Getters and setters
}

