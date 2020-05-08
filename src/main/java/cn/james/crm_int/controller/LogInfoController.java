package cn.james.crm_int.controller;


import cn.james.crm_int.common.DataGridView;
import cn.james.crm_int.common.ResultObject;
import cn.james.crm_int.entity.LogInfo;
import cn.james.crm_int.service.LogInfoService;
import cn.james.crm_int.vo.LogInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * <p>
 * 日志记录 前端控制器
 * </p>
 *
 * @author James
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/logInfo")
public class LogInfoController {
    @Autowired
    private LogInfoService logInfoService;

    // 全查询
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LogInfoVo logInfoVo){
        IPage<LogInfo> page=new Page<>(logInfoVo.getPage(), logInfoVo.getLimit());
        QueryWrapper<LogInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(logInfoVo.getLoginName()), "login_Name", logInfoVo.getLoginName());
        queryWrapper.like(StringUtils.isNotBlank(logInfoVo.getLoginIp()), "login_IP", logInfoVo.getLoginIp());
        queryWrapper.ge(logInfoVo.getStartTime() != null, "login_time", logInfoVo.getStartTime());
        queryWrapper.le(logInfoVo.getEndTime() != null, "login_time", logInfoVo.getEndTime());
        //最新登录
        queryWrapper.orderByDesc("login_time");
        this.logInfoService.page(page, queryWrapper);

        return new DataGridView(page.getTotal(), page.getRecords());

    }

    // 删除
    @RequestMapping("deleteLoginfo")
    public ResultObject deleteLoginfo(Integer id){
        try{
            this.logInfoService.removeById(id);
            return ResultObject.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.DELETE_ERR;
        }
    }

    // 批量删除
    @RequestMapping("batchDeleteLoginfo")
    public ResultObject batchDeleteLoginfo(LogInfoVo logInfoVo){
        System.out.println(logInfoVo);
        try{
            Collection<Serializable> idList= new ArrayList<>();
            for (Integer id:logInfoVo.getIds()) {
                idList.add(id);
            }
            this.logInfoService.removeByIds(idList);
            return ResultObject.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.DELETE_ERR;
        }
    }
}
