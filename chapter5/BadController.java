import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BadController {
    AtomicLong counter = new AtomicLong();

    public BadController() {
    }

    @GetMapping("/count")
    public Long addCount() {
        Long count = counter.incrementAndGet();
        return count;
    }
}
