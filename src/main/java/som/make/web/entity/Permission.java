package som.make.web.entity;

public class Permission {

    private Long permissionid;
    private String permissionname;
    private String permissiondescription;
    private Long parentid;
    private String permission;
    private Long createuserid;
    private String createdate;
    private Long updateuserid;
    private String updatedate;
    private String remarks;
    private String del_flag;

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getPermissiondescription() {
        return permissiondescription;
    }

    public void setPermissiondescription(String permissiondescription) {
        this.permissiondescription = permissiondescription;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Long createuserid) {
        this.createuserid = createuserid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public Long getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(Long updateuserid) {
        this.updateuserid = updateuserid;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionid=" + permissionid +
                ", permissionname='" + permissionname + '\'' +
                ", permissiondescription='" + permissiondescription + '\'' +
                ", parentid=" + parentid +
                ", permission='" + permission + '\'' +
                ", createuserid=" + createuserid +
                ", createdate='" + createdate + '\'' +
                ", updateuserid=" + updateuserid +
                ", updatedate='" + updatedate + '\'' +
                ", remarks='" + remarks + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }
}
