package cn.james.crm_int.common;

public interface Constast {

    // 状态码
    public static final Integer OK=200;
    public static final Integer ERROR=-1;

    // 菜单权限类型
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_PERMISSION = "menu";

    // 可用状态
    public static final Integer TYPE_AVAILABLE_TRUE = 1;
    public static final Integer TYPE_AVAILABLE_FALSE = 0;

    // 用户类型
    public static final Object USER_TYPE_SUPER = 1;
    public static final Object USER_TYPE_NORMAL = 2;


    // 展开类型
    public static final Object OPEN_TRUE = 1;
    public static final Object OPEN_FALUE = 0;


}
