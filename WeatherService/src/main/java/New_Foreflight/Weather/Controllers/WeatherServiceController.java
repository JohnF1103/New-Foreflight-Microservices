package New_Foreflight.Weather.Controllers;

import New_Foreflight.Weather.Service.Weatherservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherServiceController {

    @Autowired
    Weatherservice weatherservice;


    @GetMapping("/getGreeting")
    public String getHelloEndpoint(){

        return weatherservice.getGreeting();
    }

}
