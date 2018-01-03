package som.make.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import som.make.sherman.security.ShermanAuthorizingRealm.Principal;
import som.make.web.dao.UserDao;
import som.make.web.entity.Permission;
import som.make.web.entity.User;
import som.make.web.entity.UserPermission;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
    private static CacheManager cacheManager = SpringContextHolder.getBean("cacheManager");

    public static final String AUTHORIZACACHENAME = "authorizationCache";

    /**
     * 获取当前登录的用户身份
     * @return
     */
    public static Principal getPrincipal() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal) subject.getPrincipal();
            if (principal != null) {
                return principal;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前subject的session
     * @return
     */
    public static Session getSession() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if (session == null) {
                session = subject.getSession();
            }
            if (session != null) {
                return session;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean saveAuthzToCache(String alias, String key, SimpleAuthorizationInfo simpleAuthorizationInfo) {
        Cache cache = cacheManager.getCache(alias, key.getClass(), simpleAuthorizationInfo.getClass());
        if (cache != null) {
            cache.put(key, simpleAuthorizationInfo);
            return true;
        }
        return false;
    }

    public static SimpleAuthorizationInfo getAuthzFormCache(String alias, String key) {
        Cache cache = cacheManager.getCache(alias, key.getClass(), SimpleAuthorizationInfo.class);
        if (cache != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = (SimpleAuthorizationInfo) cache.get(key);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 获取当前用户
     * @return
     */
    public static User getUser() {
        Principal principal = getPrincipal();
        if (principal != null) {
            User user = getUserByUserid(principal.getUserid());
            if (user != null) {
                return user;
            }
            return new User();
        }
        return new User();
    }

    /**
     * 根据用户Id获取用户
     * @param userid
     * @return
     */
    public static User getUserByUserid(Long userid) {
        User user = userDao.userQueryByUserid(userid);
        return user;
    }

    /**
     * 根据用户名获取user
     * @param username
     * @return
     */
    public static User getUserByUsername(String username) {
        User user = userDao.userQueryByUsername(username);
        if (user == null) {
            return null;
        }
        return user;
    }

    /**
     * 获取当前用户的权限列表
     * @return
     */
    public static List<UserPermission> getPermissionList() {
        List<UserPermission> userPermissionList = new ArrayList<>();
        User user = getUser();
        if (user.isAdmin()) {
            UserPermission userPermission = new UserPermission(user.getUserid(), user.getUsername(), 0L, "*");
            userPermissionList.add(userPermission);
            return userPermissionList;
        } else {
            userPermissionList = userDao.userPermissionQueryByUserid(user.getUserid());
            return userPermissionList;
        }
    }
}
