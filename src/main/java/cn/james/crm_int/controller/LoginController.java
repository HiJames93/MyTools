package cn.james.crm_int.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 给普通跳转使用(非ajax)
 */
@Controller
public class LoginController {

    // 登录
    @RequestMapping("login")
    public String Login(){
        return "login";
    }

    // 首页
    @RequestMapping("index")
    public String Index(){
        return "sys/index";
    }

    //后台首页
    @RequestMapping("main")
    public String toMain(){
        return "sys/main";
    }

    //日志
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

    /**
     * 公告
     * @return
     */
    // 显示
    @RequestMapping("/sys/toNoticeManager")
    public String toNoticeManager(){
        return "sys/sysNotice/noticeInfo";
    }

    // 添加
    @RequestMapping("/sys/addNotice")
    public String addNotice(){
        return "sys/sysNotice/addNotice";
    }

    /**
     * 图标管理
     */
    @RequestMapping("/sys/showIcon")
    public String showIcon(){
        return "sys/icons";
    }

    /**
     * 转到部门管理
     * @return
     */
    @RequestMapping("/sys/toDeptManager")
    public String toDeptManager(){
        return "sys/dept/deptManager";
    }

    @RequestMapping("/sys/toDeptRight")
    public String toDeptRight(){
        return "sys/dept/deptRight";
    }

    @RequestMapping("/sys/toDeptLeft")
    public String toDeptLeft(){
        return "sys/dept/deptLeft";
    }
}
