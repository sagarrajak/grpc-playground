package com.grpc_playground.grcp_playgroud.sec02;

import com.grpc_playground.grcp_playgroud.model.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    private static Person createPerson() {
        return Person.newBuilder().setName("sagar").setAge(32).build();
    }

    public static void main(String[] args) {
        var person1 = createPerson();
        var person2 = createPerson();

        log.info("Comparing person1 and person2, {} ", person1.equals(person2));
        log.info("Comparing person1 and person2, {} ", person1 == person2);


        // mutable ?? No
        Person person3 = person1.toBuilder().setName("Joe").build();

        // compare
        log.info("Comparing person1 and person3, {} ", person3.equals(person2));
        log.info("Comparing person1 and person3, {} ", person3 == person2);

        // set null value
        Person person4 = person3.toBuilder().clearName().build();
        log.info("Person 4 {}", person4);


//        log.info("sagar: {}", sagar);
//        log.info("Person Name: {}", sagar.getName());
//        log.info("Person Age: {}", sagar.getAge());
    }
}
