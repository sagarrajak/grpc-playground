package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private static final Logger log =  LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {
        var person = getPerson();
        serializePerson(person);
        log.info("Person  {}", deserializePerson());
        log.info("Person byte array {}", person.toByteArray().length);
    }

    private static Person getPerson() {
        return Person.newBuilder()
                .setAge(31)
                .setFirstName("Sagar")
                .setLastName("rajak")
                .setEmail("Sagar@gmail.com")
                .setBankAccountNumber(12345678902323L)
                .setBalance(-1000)
                .setSalery(10000.12345)
                .build();
    }

    private static void serializePerson(Person person) throws IOException {
        try (var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
    }

    private static Person deserializePerson() throws IOException {
        try(var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
    }
}
