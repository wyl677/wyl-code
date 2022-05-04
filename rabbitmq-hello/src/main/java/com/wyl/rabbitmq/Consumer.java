package com.wyl.rabbitmq;


import com.rabbitmq.client.*;

/**
 * Author:yanl.wang
 * Date:2022/4/24 0:15
 * 消费者 接收消息
 */
public class Consumer {
    //队列的名称
    public static final String QUEUE_NAME = "hello";//ctrl+shift+U 大小写转换
    //接收消息
    public static void main(String[] args) throws Exception {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP 连接RabbitMQ的队列
        factory.setHost("120.77.66.45");
        //设置用户名和密码
        factory.setUsername("wyl");
        factory.setPassword("123456");
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println(new java.lang.String(message.getBody()));
        };

        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag->{
            System.out.println("消息消费被中断");
        };

        /**
         * 消费者消费消息
         * 1.消费那个队列
         * 2.消费成功后是否要自动应答 true自动应答   false手动应答
         * 3.消费者未成功消费的回调
         * 4.消费者取消消费的回调
         */

        //消费者消费消息
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);

    }

}
