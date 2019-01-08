package com.xlbs.job.joba;

import org.springframework.batch.item.ItemProcessor;

public class JobAProcessor implements ItemProcessor {

    public Object process(Object o) throws Exception {
        System.out.println("JobAProcessor===>" + o.toString());
        return null;
    }

}
