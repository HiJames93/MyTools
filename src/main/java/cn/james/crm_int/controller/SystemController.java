package cn.james.crm_int.controller;

import cn.james.crm_int.common.ActiverUser;
import cn.james.crm_int.common.ResultObject;
import cn.james.crm_int.common.WebUtils;
import cn.james.crm_int.utils.loginfo.IpUtil;
import cn.james.crm_int.utils.loginfo.LogUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 专门搞ajax的地方。其他跳转滚一边去！
 */
@RestController
@RequestMapping("sys")
public class SystemController {

    //获取ip
    @RequestMapping(value = "/getIp", method = RequestMethod.POST)
    @ResponseBody
    public String getIp(HttpServletRequest request) {
        return IpUtil.getIpAddr(request);
    }

    @RequestMapping("toLogin")
    public ResultObject toLogin(String realName, String pwd, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(realName, pwd);
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user", activerUser.getUser());


            //获取ip
            String LoginIP = IpUtil.getIpAddr(request);
            // 写入日志
            LogUtils.insertLog(activerUser.getUser(),LoginIP);

            return ResultObject.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObject.LOGIN_ERR_PASS;
        }
    }

    /**
     * 信息收集
     */
    // ip
//    @RequestMapping("discoverHost")
//    public ResultObject collectInfo(){
//
//    }

}
