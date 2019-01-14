package com.xlbs.job.joba;

import org.springframework.batch.item.ItemProcessor;

public class JobAProcessor implements ItemProcessor<DeviceCommand,DeviceCommand> {


    public DeviceCommand process(DeviceCommand deviceCommand) throws Exception {
        System.out.println("==>>"+deviceCommand.getId()+"---"+deviceCommand.getStatus());
        return deviceCommand;
    }
}
