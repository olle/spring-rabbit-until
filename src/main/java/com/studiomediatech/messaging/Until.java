package com.studiomediatech.messaging;

import org.springframework.amqp.core.Message;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;


public class Until {

    public static Until timeout(TimeUnit unit, long timeout) {

        return null;
    }


    public static Until atLeast(int count) {

        return null;
    }


    public static Until atMost(int count) {

        return null;
    }


    public static Until message(Predicate<Message> message) {

        return null;
    }
}
