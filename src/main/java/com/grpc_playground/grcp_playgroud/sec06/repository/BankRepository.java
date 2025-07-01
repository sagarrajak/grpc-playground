package com.grpc_playground.grcp_playgroud.sec06.repository;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankRepository {
    private static final Map<Integer, Integer> db = IntStream.rangeClosed(1, 100).boxed()
            .collect(Collectors.toMap(Function.identity(), v -> 100));

    public static Integer getBalance(Integer accountNumber) {
        return db.get(accountNumber);
    }
}
