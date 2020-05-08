package cn.james.crm_int.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static cn.james.crm_int.common.Constast.ERROR;
import static cn.james.crm_int.common.Constast.OK;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObject {

    public static final ResultObject LOGIN_SUCCESS = new ResultObject(OK,"登录成功");
    public static final ResultObject LOGIN_ERR_PASS = new ResultObject(ERROR,"登录失败，用户名或密码不正确");
    public static final ResultObject LOGIN_ERR_CODE = new ResultObject(ERROR,"登录失败，验证码错误");


    public static final ResultObject UPDATE_SUCCESS = new ResultObject(OK,"更新成功");
    public static final ResultObject UPDATE_ERR = new ResultObject(ERROR,"更新失败");

    public static final ResultObject DELETE_SUCCESS = new ResultObject(OK,"删除成功");
    public static final ResultObject DELETE_ERR = new ResultObject(ERROR,"删除失败");

    public static final ResultObject ADD_SUCCESS = new ResultObject(OK,"添加成功");
    public static final ResultObject ADD_ERR = new ResultObject(ERROR,"添加失败");

    public static final ResultObject RESET_SUCCESS = new ResultObject(OK,"重置成功");
    public static final ResultObject RESET_ERR = new ResultObject(ERROR,"重置失败");

    public static final ResultObject DISPATCH_SUCCESS = new ResultObject(OK,"分配成功");
    public static final ResultObject DISPATCH_ERR = new ResultObject(ERROR,"分配失败");


    private Integer code;
    private String msg;
}
