package cn.james.crm_int.controller;

import cn.james.crm_int.common.DataGridView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conversion")
public class FormatConversionController {
    // 接收
    @RequestMapping("get")
    public DataGridView toGet(){
        return new DataGridView(null);
    }
    // 发送
    @RequestMapping("send")
    public DataGridView toSend(){
        return new DataGridView(null);
    }
}
