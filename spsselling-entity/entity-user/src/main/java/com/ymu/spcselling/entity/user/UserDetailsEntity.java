package com.ymu.spcselling.entity.user;

import com.ymu.spcselling.entity.constants.UserSexType;
import com.ymu.spcselling.infrastructure.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户详细信息表。
 */
@Entity(name = "user_details")
@Table(indexes = {
        // 非唯一索引。
        @Index(name = "idx_user_age", columnList = "age")
})
public class UserDetailsEntity extends BaseEntity {


    private static final long serialVersionUID = -1384159351138305138L;

    /**
     * 用户真实姓名。
     */
    @Column(length = 80)
    private String realName;

    /**
     * 性别。
     */
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserSexType userSexType;

    /**
     * 年龄。
     */
    @Column(length = 3)
    private Integer age;

    /**
     * 出生时间。
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date bornTime;

    /**
     * 身份证号码。
     */
    @Column(length = 100,unique = true)
    private String idCardNum;

    /**
     * 常住地址。
     */
    @Column(length = 150)
    private String houseAddr;
}
