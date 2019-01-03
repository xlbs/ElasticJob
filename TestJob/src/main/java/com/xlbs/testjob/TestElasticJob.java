package com.xlbs.testjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class TestElasticJob implements SimpleJob {

    public void execute(ShardingContext shardingContext) {

        System.out.println("=====>>>> dddddd");

    }


}
