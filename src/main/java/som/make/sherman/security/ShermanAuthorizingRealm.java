package som.make.sherman.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import som.make.common.utils.UserUtils;
import som.make.web.entity.User;
import som.make.web.entity.UserPermission;

import java.io.Serializable;
import java.util.List;

@Service
public class ShermanAuthorizingRealm extends AuthorizingRealm implements InitializingBean{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public ShermanAuthorizingRealm() {

    }

    @Override
    public String getName() {
        return "ShermanAuthorizingRealm";
    }

    /**
     * 鉴权方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Principal principal = (Principal) getAvailablePrincipal(principals);
        User user = UserUtils.getUserByUsername(principal.getUsername());
        if (user != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            List<UserPermission> userPermissionList = UserUtils.getPermissionList();
            for (UserPermission userPermission: userPermissionList) {
                String permission = StringUtils.clean(userPermission.getPermission());
                if (StringUtils.hasLength(permission)) {
                    simpleAuthorizationInfo.addStringPermission(permission);
                }
            }
            //添加一般用户权限
            simpleAuthorizationInfo.addStringPermission("generaluser");
            return simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 认证方法，用户登录调用
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected org.apache.shiro.authc.AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        //String password = new String(usernamePasswordToken.getPassword());
        User user = UserUtils.getUserByUsername(username);
        if (user == null) {
            return null;
        } else {
            return new SimpleAuthenticationInfo(new Principal(user), user.getPassword(), getName());
        }
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        return doGetAuthorizationInfo(principals);
    }

    @Override
    public void afterPropertiesSet() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-1");
        setCredentialsMatcher(hashedCredentialsMatcher);
    }

    public static class Principal implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long userid;
        private String username;
        private String showname;

        public Principal(User user) {
            this.userid = user.getUserid();
            this.username = user.getUsername();
            this.showname = user.getShowname();
        }

        public Long getUserid() {
            return userid;
        }

        public void setUserid(Long userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getShowname() {
            return showname;
        }

        public void setShowname(String showname) {
            this.showname = showname;
        }
    }
}
