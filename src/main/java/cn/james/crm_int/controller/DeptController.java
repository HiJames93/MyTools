package cn.james.crm_int.controller;


import cn.james.crm_int.common.DataGridView;
import cn.james.crm_int.entity.Dept;
import cn.james.crm_int.service.DeptService;
import cn.james.crm_int.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author James
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

//    public DataGridView loadDeptManagerLeftTreeJson(DeptVo deptVo){
//        List<Dept> list = this.deptService.list();
//    }

}
