package cn.james.crm_int.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 日志记录
 * </p>
 *
 * @author James
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_logInfo")
public class LogInfo extends Model<LogInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 访问者ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 访问者名字
     */
    @TableField("login_Name")
    private String loginName;

    /**
     * 访问者IP
     */
    @TableField("login_IP")
    private String loginIp;

    /**
     * 登陆时间
     */
    private Date loginTime;

    /**
     * 日志记录
     */
    @TableField("log_Info")
    private String logInfo;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
