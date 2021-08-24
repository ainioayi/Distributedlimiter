package com.bobo.distributedlimiter;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Bobo
 * @date 2021/8/24
 * @apiNote 自定义处理限流逻辑类
 */
@Component
@Slf4j
public final class ExceptionUtil {


    public static void handlerException(BlockException e){
        log.info("Oops:",e.getClass().getCanonicalName());
    }


}
