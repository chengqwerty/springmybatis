package som.make.web.entity;

public class UserPermission {

    private Long userid;
    private String username;
    private Long permissionid;
    private String permission;

    public UserPermission(){

    }

    public UserPermission(Long userid, String username, Long permissionid, String permission) {
        this.userid = userid;
        this.username = username;
        this.permissionid = permissionid;
        this.permission = permission;
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

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserPermission{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", permissionid=" + permissionid +
                ", permission='" + permission + '\'' +
                '}';
    }
}
