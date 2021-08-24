package com.bobo.distributedlimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.IntFunction;

/**
 * @author Bobo
 * @date 2021/8/23
 * @apiNote
 */
@RestController
@Slf4j
public class LimiterController {

    //存内存
    private RateLimiter rateLimiter = RateLimiter.create(10);


    @GetMapping("/guava")
    public void guava(){
        //创建可放2个令牌的桶，并且每秒产生2个令牌

        //平滑输出，guava允许突发流量
//        log.info("{}",rateLimiter.acquire(3));
//        log.info("{}",rateLimiter.acquire());
//        log.info("{}",rateLimiter.acquire());
//        log.info("{}",rateLimiter.acquire());
//        log.info("{}",rateLimiter.acquire());
//        log.info("{}",rateLimiter.acquire());

        //示例2. 抢购,桶有10个令牌，但是有11个抢到，这个需要扣库存，下单的步骤增加校验，因为guava是允许突发流量的
        /*
        2021-08-23 15:33:55.810  INFO 8404 --- [nio-8083-exec-1] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.825  INFO 8404 --- [nio-8083-exec-2] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.825  INFO 8404 --- [nio-8083-exec-5] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-6] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-3] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-7] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-4] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-8] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-9] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [io-8083-exec-10] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.826  INFO 8404 --- [nio-8083-exec-1] c.b.d.LimiterController                  : 恭喜你，抢到了
        2021-08-23 15:33:55.828  INFO 8404 --- [io-8083-exec-10] c.b.d.LimiterController                  : 不好意思，手速慢了，没抢到
         */
        boolean tryAcquire = rateLimiter.tryAcquire();
        if (tryAcquire){
            //扣库存，下单
            log.info("恭喜你，抢到了");
        }else {
            log.info("不好意思，手速慢了，没抢到");
        }
    }

    @GetMapping("/sentinel")
    public String sentinel() {
        return "sentinel";
    }
}
