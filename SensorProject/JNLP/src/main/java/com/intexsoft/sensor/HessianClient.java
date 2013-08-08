package com.intexsoft.sensor;

import com.intexsoft.sensor.CommonAPI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: sergey.berdashkevich
 * Date: 02.08.13
 */
public class HessianClient {
    public String getData()  {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/spring/hessian-config.xml");

        CommonAPI service = (CommonAPI) appContext.getBean("commonAPIService");

        String message = service.getData();

        return message;
    }
}
