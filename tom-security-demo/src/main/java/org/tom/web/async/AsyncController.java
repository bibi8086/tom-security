package org.tom.web.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 异步控制器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午8:51
 */
@RestController
@RequestMapping("orders")
public class AsyncController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    // 同步处理
    @GetMapping("/sync")
    public String syncOrder() throws Exception {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程返回");
        return "success";
    }

    // 异步处理Callable方式
    @GetMapping("/async")
    public Callable<String> asyncOrder() throws Exception {
        logger.info("主线程开始");
        Callable<String> result = () -> {
            logger.info("子线程开始");
            Thread.sleep(1000);
            logger.info("子线程返回");
            return "success";
        };
        logger.info("主线程返回");
        return result;
    }

    // 异步处理DeferredResult方式
    @GetMapping("/async2")
    public DeferredResult<String> async2Order() throws Exception {
        logger.info("主线程开始");
        String orderNo = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNo);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNo, result);
        logger.info("主线程返回");
        return result;
    }
}
