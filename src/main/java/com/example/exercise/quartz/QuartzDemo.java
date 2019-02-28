package com.example.exercise.quartz;

import java.util.concurrent.TimeUnit;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import com.example.exercise.quartz.jobdetail.MyQuartz;

public class QuartzDemo {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
//        创建调度scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        定义一个触发器Trigger
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
                .startNow()// 加入scheduler立即生效
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
//        定义一个JobDetail
        JobDetail jobDetail = newJob(MyQuartz.class)
                .withIdentity("job1", "group1")
                .usingJobData("name", "quartz")
                .build();
//        加入这个调度
        scheduler.scheduleJob(jobDetail, trigger);

//        启动
        scheduler.start();

        TimeUnit.SECONDS.sleep(20);

        scheduler.shutdown(true);

    }
}
