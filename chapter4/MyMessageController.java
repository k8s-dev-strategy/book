@RestController
public class MyMessageController {
    @Value("${my-message}") String myMessage;

    @GetMapping("/hello")
    public String hello() {
        return myMessage;
    }
}