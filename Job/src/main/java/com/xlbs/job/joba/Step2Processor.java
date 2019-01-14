package com.xlbs.job.joba;

import org.springframework.batch.item.ItemProcessor;

public class Step2Processor implements ItemProcessor {

    public Object process(Object o) throws Exception {
        System.out.println("Step2Processor");
        return null;
    }

}
