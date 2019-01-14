package com.xlbs.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;


public class SpringBatchMain {

    @Autowired
    private static JobLauncher jobLauncher;

    @Autowired
    @Qualifier("jobA")
    private static Job jobA;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:/config/spring-batch.xml"});
        // 获取任务启动器
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("jobA",Job.class);
        try {
            JobExecution jobAResult = jobLauncher.run(job, new JobParameters());
            System.out.println("JobA start result: " + jobAResult.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
