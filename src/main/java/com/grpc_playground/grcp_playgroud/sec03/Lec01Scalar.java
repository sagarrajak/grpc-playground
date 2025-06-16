package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private static final Logger log =  LoggerFactory.getLogger(Lec01Scalar.class);
    public static void main(String[] args) {
        Person person = getPerson();
        log.info("Person details {}", person.toString());
    }

    private static Person getPerson() {
        return Person.newBuilder()
                .setAge(31)
                .setFirstName("Sagar")
                .setLastName("rajak")
                .setEmail("Sagar@gmail.com")
                .setBankAccountNumber(12345678902323L)
                .setBalance(-1000)
                .setSalery(10000.12345)
                .build();
    }
}
