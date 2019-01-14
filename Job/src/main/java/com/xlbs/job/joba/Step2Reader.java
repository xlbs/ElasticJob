package com.xlbs.job.joba;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Step2Reader implements ItemReader {

    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("Step2Reader");
        return null;
    }

}
