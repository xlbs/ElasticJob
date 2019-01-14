package com.xlbs.job.joba;

import org.springframework.batch.item.ItemWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class JobAWriter implements ItemWriter<DeviceCommand> {

    private final static String EVEN_FILE_NAME="C:/xlbs/Project/ElasticJob/Job/src/main/resources/batch-data-source.csv";


    public void write(List<? extends DeviceCommand> list) throws Exception {
        System.out.println("JobAWriter");
        //FileWriter第二个参数true表示追加写入文件末尾
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(EVEN_FILE_NAME)));
        StringBuffer sb = new StringBuffer();
        //循环写入文件
        for(DeviceCommand df : list) {
            sb.append(df.toString()).append(System.getProperty("line.separator"));
        }
        bw.write(sb.toString());
        if(bw != null) {
            bw.close();
        }
    }


}
