package org.tom.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 消息队列监听器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午9:58
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true) {
                if (org.apache.commons.lang3.StringUtils.isNoneBlank(mockQueue.getCompleteOrder())) {
                    String orderNo = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果： " + orderNo);
                    deferredResultHolder.getMap().get(orderNo).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
