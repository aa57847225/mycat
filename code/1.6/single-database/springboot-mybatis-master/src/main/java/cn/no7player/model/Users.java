package cn.no7player.model;

/**
 * Users表 应该作为一个全局表 这样才能关联表查询和登录
 */
public class Users {

    // 主键ID
    private int id;

    //用户名
    private String name;

    // 电话
    private String phone;

    //公司ID
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
