package com.grpc_playground.grcp_playgroud.common;

import com.grpc_playground.grcp_playgroud.sec06.BankService;

public class Demo {
    public static void main(String[] args) {
            GrpcServer.create(6565, new BankService())
                    .start()
                    .awit();
    }
}
