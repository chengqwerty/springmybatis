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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import som.make.common.utils.UserUtils;
import som.make.web.entity.User;

@Service
public class ShermanAuthorizingRealm extends AuthorizingRealm implements InitializingBean{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public ShermanAuthorizingRealm() {

    }

    @Override
    public String getName() {
        return "ShermanAuthorizingRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("user");
        simpleAuthorizationInfo.addRole("manage");
        return null;
    }

    @Override
    protected org.apache.shiro.authc.AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        //String password = new String(usernamePasswordToken.getPassword());
        User user = UserUtils.getUserByUsername(username);
        if (user == null) {
            return null;
        } else {
            return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        }
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        return super.getAuthorizationInfo(principals);
    }

    @Override
    public void afterPropertiesSet() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-1");
        setCredentialsMatcher(hashedCredentialsMatcher);
    }
}
