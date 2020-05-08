package cn.james.crm_int.controller;

import cn.james.crm_int.common.DataGridView;
import cn.james.crm_int.common.TreeNode;
import cn.james.crm_int.common.TreeNodeBuilder;
import cn.james.crm_int.common.WebUtils;
import cn.james.crm_int.entity.Permission;
import cn.james.crm_int.entity.User;
import cn.james.crm_int.service.PermissionService;
import cn.james.crm_int.vo.PermissionVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static cn.james.crm_int.common.Constast.*;


/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author James
 * @since 2020-05-04
 */

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        // 查询所有菜单
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
        // 设置只能查菜单
        queryWrapper.eq("TYPE",TYPE_MENU);
        queryWrapper.eq("OPEN",TYPE_AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list=null;
        if(user.getDid() == USER_TYPE_SUPER){
            list = permissionService.list(queryWrapper);
        }else {
            // 根据用户ID+角色+权限去查询
            list = permissionService.list(queryWrapper);
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission permission : list){
            Integer id=permission.getId();
            Integer pid=permission.getPid();
            String title=permission.getName();
            String icon=permission.getIcon();
            String href=permission.getHref();
            Boolean spread=permission.getOpen()==OPEN_TRUE?true:false;

           treeNodes.add(new TreeNode(id,pid,title,icon,href,spread));
        }
        // 构造层级关系
        List<TreeNode> list1= TreeNodeBuilder.buid(treeNodes, 1);
        return new DataGridView(list1);
    }
}
