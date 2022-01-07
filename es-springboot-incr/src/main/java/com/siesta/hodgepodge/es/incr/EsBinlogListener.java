package com.siesta.hodgepodge.es.incr;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "", consumerGroup = "", messageModel = MessageModel.BROADCASTING)
public class EsBinlogListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        // String  -> JSON

        // 是否过滤消息

        // 转化并放入Queue
    }

}
