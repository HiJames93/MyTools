package cn.james.crm_int.utils.loginfo;


import cn.james.crm_int.dao.LogInfoMapper;
import cn.james.crm_int.entity.LogInfo;
import cn.james.crm_int.entity.User;
import cn.james.crm_int.service.LogInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {

    @Autowired
//    private static LogInfoMapper logInfoMapper;
    private static LogInfoService logInfoService;


    //登录成功后插入
    public static void insertLog(User user, String ip){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        LogInfo info = new LogInfo();
        info.setId(user.getId());
        info.setLoginName(user.getRealname());
        info.setLoginIp(ip);
        info.setLoginTime(dateString);
        info.setLogInfo("");


//        logInfoMapper.insert(info);
//        logInfoService.save(info);
    }
}
