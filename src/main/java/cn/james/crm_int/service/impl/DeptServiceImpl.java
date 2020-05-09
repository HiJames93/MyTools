package cn.james.crm_int.service.impl;

import cn.james.crm_int.entity.Dept;
import cn.james.crm_int.dao.DeptMapper;
import cn.james.crm_int.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author James
 * @since 2020-05-09
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
