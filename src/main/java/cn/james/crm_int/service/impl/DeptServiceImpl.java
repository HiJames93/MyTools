package cn.james.crm_int.service.impl;

import cn.james.crm_int.entity.Dept;
import cn.james.crm_int.dao.DeptMapper;
import cn.james.crm_int.service.DeptService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

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

    @Override
    public boolean update(Dept entity, Wrapper<Dept> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public Dept getOne(Wrapper<Dept> queryWrapper) {
        return null;
    }

    @Override
    public boolean removeById(Serializable id){
        return super.removeById(id);
    }
}
