package com.shiro.shirodemo.shiro;

import com.shiro.shirodemo.model.Permision;
import com.shiro.shirodemo.model.Role;
import com.shiro.shirodemo.model.User;
import com.shiro.shirodemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权使用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从session中获取用户
        User user=(User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permistionList = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for (Role r:roles) {
            Set<Permision> permistion = r.getPermisionSet();
            for (Permision p:permistion) {
                permistionList.add(p.getName());
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permistionList);
        return info;
    }

    /**
     * 认证使用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String userName = usernamePasswordToken.getUsername();
        User user=userService.findByUserName(userName);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
