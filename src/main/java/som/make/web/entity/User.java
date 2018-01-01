package som.make.web.entity;

public class User {

    private Long userid;
    private String username;
    private String password;
    private String showname;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public boolean isAdmin(){
        return isAdmin(this.userid);
    }

    public static boolean isAdmin(Long userid) {
        if (userid == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", showname='" + showname + '\'' +
                '}';
    }
}
