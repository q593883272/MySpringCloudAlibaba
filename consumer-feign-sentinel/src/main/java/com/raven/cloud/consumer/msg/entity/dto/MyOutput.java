//package com.raven.cloud.consumer.msg.entity.dto;
//
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//
///**
// * Created By Raven on 2020/3/6 21:57
// * 输出管道，消息发送到消息中间件，生产者，管道返回类型必须为MessageChannel
// */
//public interface MyOutput extends MessageChannel {
//    String OUTPUT = "myOutput";
//
//    @Output(OUTPUT)
//    MessageChannel output();
//}
