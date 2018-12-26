package com.neo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AsyncTimer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AsyncTimer.class);

    @Autowired
    private AsyncTask task;

    @Override
    public void run(String... args) throws Exception {
        long t1 = System.currentTimeMillis();
        task.doAsyncWork();

        long t2 = System.currentTimeMillis();
        log.info("async timer execute in {} ms", t2 - t1);
    }
}