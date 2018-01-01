package som.make.web.dao;

import org.springframework.stereotype.Repository;
import som.make.web.entity.User;
import som.make.web.entity.UserPermission;
import som.make.web.entity.UserRole;

import java.util.List;

@Repository
public interface UserDao {

    //根据userid获取User
    User userQueryByUserid(Long userid);
    //根据username获取User
    User userQueryByUsername(String username);
    //根据userid获取用户角色信息
    List<UserRole> userRoleQueryByUserid(Long userid);
    //根据userid获取用户权限信息
    List<UserPermission> userPermissionQueryByUserid(Long userid);
}
