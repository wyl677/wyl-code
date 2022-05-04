package com.wyl.rabbitmq.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.wyl.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @auther yanl.wang
 * @date 2022/5/4
 **/
public class Worker01 {
    //队列名称
    public static final String QUEUE_NAME = "hello";

    //接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();

        //消息的接收
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println("接收到的消息："+new String(message.getBody()));
        };

        //消息接收被取消时执行下面的内容
        CancelCallback cancelCallback = (consumerTag)->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑：");
        };

        System.out.println("C2等待接收消息......");
        //消息的接收
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);

    }
}
