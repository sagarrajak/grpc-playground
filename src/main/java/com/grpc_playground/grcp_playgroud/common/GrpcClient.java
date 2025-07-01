package com.grpc_playground.grcp_playgroud.common;

import com.grpc_playground.grcp_playgroud.model.sec06.BalanceCheckRequest;
import com.grpc_playground.grcp_playgroud.model.sec06.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient {
    public static final Logger logger = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
        var stub = BankServiceGrpc.newBlockingStub(channel);

        var balanceCheckRequest = BalanceCheckRequest.newBuilder().setAccountNumber(200).build();
        var balance = stub.getAccountBalance(balanceCheckRequest);
        logger.info("Found balance {}", balance);
    }
}
