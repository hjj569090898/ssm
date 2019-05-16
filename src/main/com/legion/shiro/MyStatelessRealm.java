package legion.shiro;

import legion.entity.User;
import legion.service.PermissionService;
import legion.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import legion.util.JWTUtil;
import java.util.List;
import java.awt.*;

public class MyStatelessRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(MyStatelessRealm.class);

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String msg =JWTUtil.getUserFromToken(principals.toString());
        List permission = permissionService.listPermission(msg); //获得角色权限List
        List grouppermission = permissionService.listGroupPermission(msg);//获得组权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(permission);
        simpleAuthorizationInfo.addRoles(grouppermission);
        logger.info(msg);
        return simpleAuthorizationInfo;
    }

    /**
     * 获取登陆验证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 开始验证token 查看token携带的username是否为null -》 username和数据库中的数据比较 -》校验token
        String username = JWTUtil.getUserFromToken(token);
        User user =userService.listUserByName(username);

        if(!JWTUtil.verify(token,username,user.getEmail()))
        {
            throw new AuthenticationException("Token invalid");
        }
//        logger.info(username);

//        if (username == null) {
//            throw new AuthenticationException("Token invalid");
//        }
        // 验证用户是否存在
//        UserBean userBean = userService.getUser(username);
//        if (userBean == null) {
//            throw new AuthenticationException("User didn't existed");
//        }
//        // 校验token
//        if (!JWTUtil.verify(token, username,"s")) {
//            throw new AuthenticationException("Username or password error");
//        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

}
