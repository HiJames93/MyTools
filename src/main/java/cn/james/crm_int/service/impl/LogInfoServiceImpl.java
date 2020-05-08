package cn.james.crm_int.service.impl;

import cn.james.crm_int.entity.LogInfo;
import cn.james.crm_int.dao.LogInfoMapper;
import cn.james.crm_int.service.LogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志记录 服务实现类
 * </p>
 *
 * @author James
 * @since 2020-05-07
 */
@Service
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements LogInfoService {

}
