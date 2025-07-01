package com.grpc_playground.grcp_playgroud.sec06;

import com.grpc_playground.grcp_playgroud.model.sec06.AccountBalance;
import com.grpc_playground.grcp_playgroud.model.sec06.BalanceCheckRequest;
import com.grpc_playground.grcp_playgroud.model.sec06.BanckService;
import com.grpc_playground.grcp_playgroud.model.sec06.BankServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver){
        var accountBalance = AccountBalance.newBuilder()
                .setBalance(1000)
                .setAccountNumber(request.getAccountNumber())
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }
}
