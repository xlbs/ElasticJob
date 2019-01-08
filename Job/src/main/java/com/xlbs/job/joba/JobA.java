package com.xlbs.job.joba;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JobA implements SimpleJob {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("jobA")
    private Job jobA;

    public void execute(ShardingContext shardingContext) {

        System.out.println(String.format("JobA: Thread ID: %s, 任务总片数: %s, 当前分片项: %s", Thread.currentThread().getId(),shardingContext.getShardingTotalCount(),shardingContext.getShardingItem()));
        try {
            JobExecution jobAResult = jobLauncher.run(jobA, new JobParameters());
            System.out.println("JobA start result: " + jobAResult.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
