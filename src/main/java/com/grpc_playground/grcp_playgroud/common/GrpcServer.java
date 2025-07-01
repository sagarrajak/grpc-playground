package com.grpc_playground.grcp_playgroud.common;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class GrpcServer {
    private static final Logger log = LoggerFactory.getLogger(GrpcServer.class);

    private final Server server;

    private GrpcServer(Server server) {
        this.server = server;
    }

    public static GrpcServer create(int port, BindableService ...services) {
        var builder = ServerBuilder.forPort(port);
        Arrays.asList(services).forEach(builder::addService);
        return new GrpcServer(builder.build());
    }


    public GrpcServer start() {
        var services = server.getServices()
                .stream()
                .map(s -> s.getServiceDescriptor())
                .map(s -> s.getName())
                .toList();
        log.info("starting service {}", services);
        try {
            server.start();
            log.info("server started listing to port {}", server.getPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }


    public GrpcServer awit() {
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }


    public GrpcServer stop() {
        try {
            server.shutdownNow();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
