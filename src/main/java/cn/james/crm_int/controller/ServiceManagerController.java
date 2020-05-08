package cn.james.crm_int.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("infoService")
public class ServiceManagerController {
    @RequestMapping("show")
    public String ShowInfoService(){
        return "sys/host/hostService";
    }

    @RequestMapping("formatConversion")
    public String FormatConversion(){
        return "sys/host/formatConversion";
    }

}
