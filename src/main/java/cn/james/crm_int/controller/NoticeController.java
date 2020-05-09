package cn.james.crm_int.controller;


import cn.james.crm_int.common.DataGridView;
import cn.james.crm_int.common.ResultObject;
import cn.james.crm_int.common.WebUtils;
import cn.james.crm_int.entity.Notice;
import cn.james.crm_int.entity.User;
import cn.james.crm_int.service.NoticeService;
import cn.james.crm_int.vo.NoticeVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 公告 前端控制器
 * </p>
 *
 * @author James
 * @since 2020-05-08
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;


    /**
     * 查询
     */
    @RequestMapping("loadAllNotice")
    public DataGridView loadAllNotice(NoticeVo noticeVo){
        IPage<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        // 根据标题，时间，发布者查询
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()),"title", noticeVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getOpername()),"opername", noticeVo.getOpername());
        queryWrapper.ge(noticeVo.getStartTime() != null,"createtime", noticeVo.getStartTime());
        queryWrapper.le(noticeVo.getEndTime() != null,"createtime", noticeVo.getEndTime());
        // 最新的放在前面
        queryWrapper.orderByDesc("createtime");
        this.noticeService.page(page, queryWrapper);
        return new DataGridView(page.getTotal(), page.getRecords());
    }


    // 添加公告
    @RequestMapping("addNotice")
    public ResultObject addNotice(NoticeVo noticeVo){
        try{
            noticeVo.setCreatetime(new Date());
            User user = (User) WebUtils.getSession().getAttribute("user");
            noticeVo.setOpername(user.getRealname());
            this.noticeService.save(noticeVo);
            return ResultObject.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.ADD_ERR;
        }
    }
}
