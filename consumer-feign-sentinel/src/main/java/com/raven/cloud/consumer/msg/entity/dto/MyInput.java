//package com.raven.cloud.consumer.msg.entity.dto;
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.messaging.SubscribableChannel;
//
///**
// * Created By Raven on 2020/3/6 21:57
// * 输入管道，监听接收消息，消息消费者，管道返回类型必须为SubscribableChannel
// */
//public interface MyInput extends SubscribableChannel {
//    String INPUT = "myInput";
//
//    @Input(INPUT)
//    SubscribableChannel input();
//}