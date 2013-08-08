package com.intexsoft.sensor.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: sergey.berdashkevich
 * Date: 08.08.13
 */
@Controller
@RequestMapping("api")
public class Service {

    @RequestMapping("getData")
    @ResponseBody
    public String getData() {

        return "Data";
    }

}
