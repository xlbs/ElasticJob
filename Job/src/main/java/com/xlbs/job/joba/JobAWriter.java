package com.xlbs.job.joba;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class JobAWriter implements ItemWriter {

    public void write(List list) throws Exception {
        System.out.println("ItemWriter");

    }

}
