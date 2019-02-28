package com.example.exercise.quartz.jobdetail;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyQuartz implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String name = jobDetail.getJobDataMap().getString("name");
        System.out.println("hello    " + name + "  at time   " + new Date());
    }
}
