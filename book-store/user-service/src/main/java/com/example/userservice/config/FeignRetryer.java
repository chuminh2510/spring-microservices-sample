package com.example.userservice.config;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class FeignRetryer implements Retryer {
    @Override
    public void continueOrPropagate(RetryableException e) {
        log.error("Oops !!!", e);
//        throw e;
    }

    @Override
    public Retryer clone() {
        return new Default(100, TimeUnit.SECONDS.toMillis(10), 5);
    }
}
