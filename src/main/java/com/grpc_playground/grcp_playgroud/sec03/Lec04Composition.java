package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.Address;
import com.grpc_playground.grcp_playgroud.model.sec03.School;
import com.grpc_playground.grcp_playgroud.model.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {
    private static final Logger log = LoggerFactory.getLogger(Lec04Composition.class);

    public static void main(String[] args) {
        var address = Address.newBuilder()
                .setCity("San Francisco")
                .setState("CA")
                .setStreet("Main Street")
                .build();
        var student = Student.newBuilder()
                .setAddress(address)
                .setName("John Smith")
                .build();
        var school = School.newBuilder()
                .setAddress(address)
                .setName("sagar")
                .setId(1)
                .build();
        log.info("Composition of School: {}", school);
        log.info("Composition of Student: {}", student);
        log.info("Composition of Address: {}", address);
    }
}
