package com.xlbs.job.joba;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class JobAReader implements ItemReader<DeviceCommand> {


    public DeviceCommand read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("JobAReader");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setId("856");
        deviceCommand.setStatus("测试数据");
        return deviceCommand;
    }
}
