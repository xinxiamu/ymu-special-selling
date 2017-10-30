package com.ymu.spcselling.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserDetails is a Querydsl query type for UserDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserDetails extends EntityPathBase<UserDetails> {

    private static final long serialVersionUID = -490562539L;

    public static final QUserDetails userDetails = new QUserDetails("userDetails");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DateTimePath<java.util.Date> bornTime = createDateTime("bornTime", java.util.Date.class);

    //inherited
    public final DateTimePath<java.util.Date> dateCreated = _super.dateCreated;

    //inherited
    public final BooleanPath disabled = _super.disabled;

    public final StringPath houseAddr = createString("houseAddr");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath idCardNum = createString("idCardNum");

    //inherited
    public final DateTimePath<java.util.Date> lastUpdated = _super.lastUpdated;

    public final StringPath realName = createString("realName");

    public final EnumPath<com.ymu.spcselling.entity.constants.UserSexType> userSexType = createEnum("userSexType", com.ymu.spcselling.entity.constants.UserSexType.class);

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QUserDetails(String variable) {
        super(UserDetails.class, forVariable(variable));
    }

    public QUserDetails(Path<? extends UserDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserDetails(PathMetadata metadata) {
        super(UserDetails.class, metadata);
    }

}

