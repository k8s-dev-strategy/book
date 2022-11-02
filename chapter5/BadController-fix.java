import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BadController {

    RedisTemplate<String, Long> redisTemplate;

    public BadController(RedisTemplate<String, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/count")
    public Long addCount() {
        ValueOperations<String, Long> counter = redisTemplate.opsForValue();
        Long count = counter.increment("Counter");
        return count;
    }
}
