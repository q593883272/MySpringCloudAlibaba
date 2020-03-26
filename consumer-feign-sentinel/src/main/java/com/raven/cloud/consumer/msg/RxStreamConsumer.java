//package com.raven.cloud.consumer.msg;
//
//import com.raven.cloud.consumer.msg.entity.dto.MyInput;
//import com.raven.cloud.consumer.msg.entity.dto.MyOutput;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.client.utils.DateUtils;
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.reactive.FluxSender;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.Date;
//
///**
// * Created By Raven on 2020/3/6 22:08
// */
//
//@Slf4j
//@Component
//public class RxStreamConsumer {
//
//    /**
//     * 方式1
//     */
//    @StreamListener
//    public @Output(MyOutput.OUTPUT)
//    Flux<String> receive020(@Input(MyInput.INPUT) Flux<Date> input) {
//        //聚合3次接收做一次反馈
//        return input
//                .map(d -> DateUtils.formatDate(d, "HH:mm:ss"))
//                .log()
//                .buffer(3)
//                .map(ds -> "rx receive1 : " + StringUtils.join(ds, ','));
//    }
//
//    /**
//     * 方式2
//     */
//    @StreamListener(MyInput.INPUT)
//    @SendTo(MyOutput.OUTPUT)
//    public Flux<String> receive021(Flux<Date> input) {
//        //聚合3次接收做一次反馈
//        return input
//                .map(d -> DateUtils.formatDate(d, "HH:mm:ss"))
//                .log()
//                .buffer(3)
//                .map(ds -> "rx receive2 : " + StringUtils.join(ds, ','));
//    }
//
//    /**
//     * 方式3
//     */
//    @StreamListener
//    public void receive022(@Input(MyInput.INPUT) Flux<Date> input, @Output(MyOutput.OUTPUT) FluxSender output) {
//        //聚合3次接收做一次反馈
//        Mono<Void> mono = output.send(
//                input.
//                        map(d -> DateUtils.formatDate(d, "HH:mm:ss"))
//                        .log()
//                        .buffer(3)
//                        .map(ds -> "rx receive3 : " + StringUtils.join(ds, ','))
//        );
//    }
//
//
//}
