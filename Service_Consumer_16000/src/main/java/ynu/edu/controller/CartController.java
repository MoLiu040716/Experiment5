package ynu.edu.controller;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
import ynu.edu.feign.ServiceProviderService;


@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartController {
    @Resource
    private ServiceProviderService serviceProviderService;
    @GetMapping("/getCartById/{userId}")
    @LoadBalanced
    public CommonResult<User>getCartById(@PathVariable("userId") Integer userId){
        CommonResult<User> result = serviceProviderService.getUserById(userId);
        System.out.println("运行正常");
        return result;
    }
}
