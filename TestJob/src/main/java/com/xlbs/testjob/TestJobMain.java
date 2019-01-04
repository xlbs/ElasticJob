package com.xlbs.testjob;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

public class TestJobMain {

    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        try(FileReader reader = new FileReader(System.getProperty("TestJob/app.properties"))) {
//            properties.load(reader);
//            System.getProperties().putAll(properties);
//        }
        FileInputStream in = new FileInputStream("TestJob/app.properties");
        properties.load(in);
        in.close();

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.<Driver>forName(properties.getProperty("r_jdbc.driverClass")));
        dataSource.setUrl(properties.getProperty("r_jdbc.url"));
        dataSource.setUsername(properties.getProperty("r_jdbc.username"));
        dataSource.setPassword(properties.getProperty("r_jdbc.password"));

        new JobScheduler(createRegistryCenter(), createJobConfiguration(),new JobEventRdbConfiguration(dataSource)).init();

    }

    private static CoordinatorRegistryCenter createRegistryCenter(){
        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration(properties.getProperty("zkServerLists"),properties.getProperty("zkNamespace")));
        registryCenter.init();
        return registryCenter;
    }

    private static LiteJobConfiguration createJobConfiguration(){
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("testJob",properties.getProperty("cron"),Integer.parseInt(properties.getProperty("shardingTotalCount")))
                .jobParameter(properties.getProperty("jobParameter"))
                .shardingItemParameters(properties.getProperty("shardingItemParameters"))
                .build();
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig,TestElasticJob.class.getCanonicalName());
        return LiteJobConfiguration.newBuilder(simpleJobConfig).build();
    }


}
