package som.make.common.utils;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class SysShiroUtils {

    /**
     * 获取当前登录用户
     * @return
     */
    public static String getPrincipal() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String)subject.getPrincipal();
        //boolean
        if (principal != null) {
            return principal;
        }
        return null;
    }
}
