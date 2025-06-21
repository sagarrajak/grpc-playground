package com.grpc_playground.grcp_playgroud.sec04;

import com.grpc_playground.grcp_playgroud.model.sec04.PersonNew;
import com.grpc_playground.grcp_playgroud.model.sec04.common.Address;
import com.grpc_playground.grcp_playgroud.model.sec04.common.BodyType;
import com.grpc_playground.grcp_playgroud.model.sec04.common.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Import {
    private static final Logger logger = LoggerFactory.getLogger(Lec01Import.class);
    public static void main(String[] args) {

        var address = Address.newBuilder().setCity("San Francisco")
                .setState("USA")
                .setStreet("Some Street")
                .build();

        var car = Car.newBuilder()
                .setBodyType(BodyType.sadan)
                .setMake("Some Make")
                .setModel("Some Model")
                .build();

        var person = PersonNew.newBuilder()
                .setAddress(address)
                .setCar(car)
                .build();
        logger.info("this is person object {}", person);
    }
}
