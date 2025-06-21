package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.Credentials;
import com.grpc_playground.grcp_playgroud.model.sec03.Email;
import com.grpc_playground.grcp_playgroud.model.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08OneOf {
    private static final Logger log = LoggerFactory.getLogger(Lec08OneOf.class);
    public static void main(String[] args) {
        Credentials emailCredentials = Credentials
                .newBuilder()
                .setEmail(
                        Email.newBuilder()
                                .setAdresss("test@grpc-playground.com")
                                .setPassword("password")
                                .build()
                ).build();
        Credentials phoneCredentials = Credentials.newBuilder()
                .setPhone(Phone.newBuilder().setCode(91).setNumber(7_347_347).build()).build();
        logic(emailCredentials);
        logic(phoneCredentials);
    }

    private static void logic(Credentials credentials) {
        switch (credentials.getLoginTypeCase()) {
            case EMAIL -> log.info("login type email : {}", credentials.getEmail());
            case PHONE -> log.info("login type phone : {}", credentials.getPhone());
            default -> log.info("login type unknown : {}", credentials.getLoginTypeCase());
        }
    }
}
