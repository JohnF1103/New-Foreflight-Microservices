package New_Foreflight.Weather.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AirportInfoResponse {
    private String metarData;
    private String flightRules;

    public AirportInfoResponse(String metarData, String flightRules) {
        this.metarData = metarData;
        this.flightRules = flightRules;
    }

    // Getters and setters
}

