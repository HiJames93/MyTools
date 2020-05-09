package cn.james.crm_int.vo;

import cn.james.crm_int.entity.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends Dept {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids;//接收多个id
}
