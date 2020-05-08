package cn.james.crm_int.realm;

import cn.james.crm_int.common.ActiverUser;
import cn.james.crm_int.entity.User;
import cn.james.crm_int.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    private Logger logger= LoggerFactory.getLogger(MyRealm.class);

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("realname",authenticationToken.getPrincipal().toString());
        User user=userService.getOne(queryWrapper);


        if (null != user){
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);
//            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, user.getPassword(), this.getName());
            return info;
        }

        // 判断密码
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}

