package com.zwwhnly.springbootdemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestSchedule {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    @Scheduled(cron = "0/5 * * * * ?")
    public void testCron() {
        System.out.println("当前时间：" + simpleDateFormat.format(new Date()));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
