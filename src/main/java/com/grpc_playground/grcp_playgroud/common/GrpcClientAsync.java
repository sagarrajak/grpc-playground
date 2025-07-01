package com.grpc_playground.grcp_playgroud.common;

import com.grpc_playground.grcp_playgroud.model.sec06.AccountBalance;
import com.grpc_playground.grcp_playgroud.model.sec06.BalanceCheckRequest;
import com.grpc_playground.grcp_playgroud.model.sec06.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClientAsync {
    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) throws InterruptedException {
        var channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
        var stub = BankServiceGrpc.newStub(channel);
        var balanceCheckRequest = BalanceCheckRequest.newBuilder().setAccountNumber(200).build();

        stub.getAccountBalance(balanceCheckRequest, new StreamObserver<>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                log.info("we received response {}" , accountBalance.getBalance());
            }
            @Override
            public void onError(Throwable throwable) {
                log.error("error {}", throwable);
            }

            @Override
            public void onCompleted() {
                log.info("Request completed");
            }
        });
        Thread.sleep(1000);
    }
}
