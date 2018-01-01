package som.make.web.entity;

public class UserRole {

    private Long userid;
    private String username;
    private Long roleid;
    private String rolename;

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

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
