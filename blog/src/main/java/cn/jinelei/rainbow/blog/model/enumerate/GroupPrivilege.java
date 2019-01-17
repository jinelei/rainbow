package cn.jinelei.rainbow.blog.model.enumerate;

/**
 * @author zhenlei
 */

public enum GroupPrivilege {
    NORMAL_USER(1, "normal"),
    ROOT_USER(2, "root");
    private int code;
    private String desc;

    GroupPrivilege(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
