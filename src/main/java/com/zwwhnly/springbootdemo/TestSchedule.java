package com.zwwhnly.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TestSchedule {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private List<Integer> index = Arrays.asList(8 * 1000, 3 * 1000, 6 * 1000, 2 * 1000, 2 * 1000);
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 每5秒执行一次
    /*@Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    // 上次任务执行结束时间与下次任务执行开始的间隔时间为5s
    /*@Scheduled(fixedDelay = 5000)
    public void testFixedDelay() {
        System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*@Scheduled(cron = "0/5 * * * * ?")
    public void testCron() {
        System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*@Scheduled(fixedRate = 5 * 1000)
    public void fixedRate() throws Exception {
        int i = atomicInteger.get();
        if (i < 5) {
            Integer sleepTime = index.get(i);
            logger.info("第{}个任务开始执行,执行时间为{}ms", i, sleepTime);
            Thread.sleep(sleepTime);
            atomicInteger.getAndIncrement();
        }
    }*/

    /*@Scheduled(cron = "0/5 * * * * ? ")
    public void cron() throws Exception {
        int i = atomicInteger.get();
        if (i < 5) {
            Integer sleepTime = index.get(i);
            logger.info("第{}个任务开始执行,执行时间为{}ms", i, sleepTime);
            Thread.sleep(sleepTime);
            atomicInteger.getAndIncrement();
        }
    }*/

    /*@Scheduled(fixedDelay = 5 * 1000)
    public void testFixedDelay() throws Exception {
        int i = atomicInteger.get();
        if (i < 5) {
            Integer sleepTime = index.get(i);
            System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
            Thread.sleep(sleepTime);
            atomicInteger.getAndIncrement();
        }
    }*/

    /*@Scheduled(fixedRate = 5000)
    public void testFixedRate() throws Exception {
        int i = atomicInteger.get();
        if (i < 5) {
            Integer sleepTime = index.get(i);
            System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
            Thread.sleep(sleepTime);
            atomicInteger.getAndIncrement();
        }
    }*/

    @Scheduled(cron = "0/5 * * * * ?")
    public void testCron() throws Exception {
        int i = atomicInteger.get();
        if (i < 5) {
            Integer sleepTime = index.get(i);
            System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
            Thread.sleep(sleepTime);
            atomicInteger.getAndIncrement();
        }
    }
}
