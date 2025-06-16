package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.Car;
import com.grpc_playground.grcp_playgroud.model.sec03.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec06DefaultValue {
    private static final Logger log = LoggerFactory.getLogger(Lec06DefaultValue.class);
    public static void main(String[] args) {
        var school = School.newBuilder().build();
        log.info("{}", school);

        log.info("School id: {}", school.getId());
        log.info("School name: {}", school.getName());
        log.info("School address: {}", school.getAddress());
        log.info("School address city: {}", school.getAddress().getCity());

        log.info("Is address is null: {}", school.hasAddress()); // check for address

        Car defaultInstance = Car.getDefaultInstance();
        log.info("Default card body type: {}", defaultInstance.getBodyType());
    }
}
