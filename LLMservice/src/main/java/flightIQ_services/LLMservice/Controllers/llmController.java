package flightIQ_services.LLMservice.Controllers;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class llmController {

    private final ChatClient chatClient;

    public llmController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/")
    public String propmpt(@RequestParam String m) {
                return null;
    }

}