package service.basic.user.config.ds;

/**
 * 数据源类型。
 *
 * @author zmt
 */
public enum DSType {

    SPCS_USER("会员库主库"),
    SPCS_USER_SLAVE("会员库从库");

    private final String value;

    DSType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
