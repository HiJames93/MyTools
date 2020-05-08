package cn.james.crm_int.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 给普通跳转使用(非ajax)
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String Login(){
        return "login";
    }

    @RequestMapping("index")
    public String Index(){
        return "sys/index";
    }

    @RequestMapping("main")
    public String toMain(){
        return "sys/main";
    }

    @RequestMapping("/sys/loginfo")
    public String toLoginfoManager(){
        return "sys/log/loginfo";
    }

    // 个人资料
    @RequestMapping("/sys/showUser")
    public String ShowUser(){
        return "sys/user/userInfo";
    }

    // 修改密码
    @RequestMapping("/sys/changePwd")
    public String changePwd(){
        return "sys/user/changePwd";
    }

    // 系统公告
//    @RequestMapping("/sys/showUser")
//    public String systemCommonInfo(){
//        return "sys/user/userInfo";
//    }


//    // 更换皮肤
//    @RequestMapping("/sys/showUser")
//    public String ChangeSkin(){
//        return "sys/user/userInfo";
//    }

    @RequestMapping("userList")
    public String ShowUserList(){
        return "sys/user/userList";
    }
}
