package com.grpc_playground.grcp_playgroud.sec01;


import com.grpc_playground.grcp_playgroud.model.sec01.PersonOuterClass;

import java.util.logging.Logger;

public class SimpleProtoDemo {
    private static Logger log = Logger.getLogger(SimpleProtoDemo.class.getName());
    public static void main(String[] args) {
        var johnDoe = PersonOuterClass.
                Person.newBuilder().setAge(12).setName("John Doe").build();
        log.info(johnDoe.toString());
    }
}
