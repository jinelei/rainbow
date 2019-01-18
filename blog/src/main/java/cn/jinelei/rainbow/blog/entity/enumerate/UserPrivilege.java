package cn.jinelei.rainbow.blog.entity.enumerate;

/**
 * @author zhenlei
 */

public enum UserPrivilege {
    TOURIST_USER(1, "normal"),
    NORMAL_USER(2, "normal"),
    ROOT_USER(4, "root");
    private int code;
    private String desc;

    UserPrivilege(int code, String desc) {
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

    public static class Constants {
        public static final int TOURIST_USER = 1;
        public static final int NORMAL_USER = 2;
        public static final int ROOT_USER = 4;
    }
}
