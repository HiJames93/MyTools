package cn.james.crm_int.service.impl;

import cn.james.crm_int.entity.Notice;
import cn.james.crm_int.dao.NoticeMapper;
import cn.james.crm_int.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告 服务实现类
 * </p>
 *
 * @author James
 * @since 2020-05-08
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
