package cn.james.crm_int.service.impl;

import cn.james.crm_int.entity.User;
import cn.james.crm_int.dao.UserMapper;
import cn.james.crm_int.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author James
 * @since 2020-05-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
