package com.xlbs.job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:/config/springBeans.xml"});
    }


}
