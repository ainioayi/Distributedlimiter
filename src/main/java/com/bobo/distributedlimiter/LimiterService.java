package com.bobo.distributedlimiter;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Bobo
 * @date 2021/8/24
 * @apiNote 自定义埋点。sentinel默认会对所有http路径设置埋点，service层可用自定义埋点进行扩展
 */
@Service
@Slf4j
public class LimiterService {

    //
    @SentinelResource(value = "LimiterService.test",blockHandler = "handlerException",blockHandlerClass = {ExceptionUtil.class})
    public void test(){
        log.info("test...");
    }

}
