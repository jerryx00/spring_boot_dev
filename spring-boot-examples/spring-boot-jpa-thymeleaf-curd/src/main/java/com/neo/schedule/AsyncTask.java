package com.neo.schedule;


import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AsyncTask {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public void doAsyncWork() {
        long t1 = System.currentTimeMillis();

        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
        }

        long t2 = System.currentTimeMillis();
        log.info("async task execute in {} ms", t2 - t1);
    }
}