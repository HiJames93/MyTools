package cn.james.crm_int.controller;

import cn.james.crm_int.common.ActiverUser;
import cn.james.crm_int.common.ResultObject;
import cn.james.crm_int.common.WebUtils;
import cn.james.crm_int.entity.Dept;
import cn.james.crm_int.entity.LogInfo;
import cn.james.crm_int.entity.User;
import cn.james.crm_int.service.DeptService;
import cn.james.crm_int.service.LogInfoService;
import cn.james.crm_int.utils.loginfo.IpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 专门搞ajax的地方。其他跳转滚一边去！
 */
@RestController
@RequestMapping("sys")
public class SystemController {

    //获取ip
    @RequestMapping(value = "/getIp", method = RequestMethod.POST)
    public String getIp(HttpServletRequest request) {
        return IpUtil.getIpAddr(request);
    }

    @Autowired
    private LogInfoService logInfoService;
    private DeptService deptService;

    @RequestMapping("toLogin")
    public ResultObject toLogin(String realName, String pwd, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(realName, pwd);
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user", activerUser.getUser());


            // 写入日志

            LogInfo entity=new LogInfo();
            //设置格式
            entity.setLoginName(activerUser.getUser().getRealname()+"-"+activerUser.getUser().getDid());
            entity.setLoginIp(WebUtils.getRequest().getRemoteAddr());
            entity.setLoginTime(new Date());
            logInfoService.save(entity);


            return ResultObject.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
//            e.printStackTrace();
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
