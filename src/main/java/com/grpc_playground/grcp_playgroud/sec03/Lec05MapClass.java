package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Lec05MapClass {
    private static final Logger logger = LoggerFactory.getLogger(Lec05MapClass.class);
    public static void main(String[] args) {
        var car = Car.newBuilder().setMake("honda")
                .setModel("civic")
                .setYear(2002)
                .setBodyType(BodyType.sadan)
                .build();
        var car2 = Car.newBuilder()
                .setMake("honda")
                .setModel("accord")
                .setBodyType(BodyType.muv)
                .setYear(2000)
                .build();
        var dealer = Dealer.newBuilder()
                .putInventory(1, car)
                .putInventory(2, car2)
                .build();
        logger.info("Dealers {}", dealer.toString());

        var car3 = Car2.newBuilder().setMake("honda")
                .setModel("civic")
                .setYear(2002)
                .build();
        var cars = Cars.newBuilder().addAllCars(List.of(car3)).build();
        ComplexDealer.newBuilder()
                .putInventory(32, cars)
                .build();

    }
}
