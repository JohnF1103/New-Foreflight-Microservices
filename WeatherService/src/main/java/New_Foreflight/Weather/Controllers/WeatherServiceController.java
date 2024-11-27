package New_Foreflight.Weather.Controllers;

import New_Foreflight.Weather.DTO.AirportInfoResponse;
import New_Foreflight.Weather.Service.Weatherservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherServiceController {

    @Autowired
    Weatherservice weatherservice;

        @GetMapping(path = "/getAirportInfo/{iaco_code}")
        public ResponseEntity<AirportInfoResponse> getAirportInfo(@RequestParam String iacoCode) {
            try {
                AirportInfoResponse response = weatherservice.getAirportInfo(iacoCode);
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

}
