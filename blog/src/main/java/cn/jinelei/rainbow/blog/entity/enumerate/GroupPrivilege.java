package cn.jinelei.rainbow.blog.entity.enumerate;

/**
 * @author zhenlei
 */

public enum GroupPrivilege {
    TOURIST_GROUP(1, "normal"),
    NORMAL_GROUP(2, "normal"),
    ROOT_GROUP(4, "root");
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

    public static class Constants {
        public static final int TOURIST_GROUP = 1;
        public static final int NORMAL_GROUP = 2;
        public static final int ROOT_GROUP = 4;
    }
}
