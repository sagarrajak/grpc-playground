package com.grpc_playground.grcp_playgroud.sec04;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.grpc_playground.grcp_playgroud.model.sec04.WrapperExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Lec05WrapperType {
    private static final Logger log = LoggerFactory.getLogger(Lec05WrapperType.class);
    public static void main(String[] args) {
        WrapperExample wrapperExample = WrapperExample.newBuilder().setAge(Int32Value.of(23)).setCreatedAt(
                Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
        ).build();

        Instant instant = Instant.ofEpochSecond(wrapperExample.getCreatedAt().getSeconds());
        log.info("CreatedAt: {}", instant);
    }
}
