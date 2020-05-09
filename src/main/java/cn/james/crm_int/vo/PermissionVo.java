package cn.james.crm_int.vo;

import cn.james.crm_int.entity.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {
    private static final long serialVersionUID = 1L;
}
