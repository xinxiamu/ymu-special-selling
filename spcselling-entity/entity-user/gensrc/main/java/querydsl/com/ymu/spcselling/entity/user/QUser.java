package com.ymu.spcselling.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1866918253L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> dateCreated = _super.dateCreated;

    //inherited
    public final BooleanPath disabled = _super.disabled;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdated = _super.lastUpdated;

    public final BooleanPath loginStatus = createBoolean("loginStatus");

    public final DateTimePath<java.util.Date> loginTime = createDateTime("loginTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> logoutTime = createDateTime("logoutTime", java.util.Date.class);

    public final StringPath mobile = createString("mobile");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final QUserDetails userDetails;

    public final StringPath userName = createString("userName");

    public final EnumPath<com.ymu.spcselling.entity.constants.UserType> userType = createEnum("userType", com.ymu.spcselling.entity.constants.UserType.class);

    public final EnumPath<com.ymu.spcselling.entity.constants.UserUsableType> userUsableType = createEnum("userUsableType", com.ymu.spcselling.entity.constants.UserUsableType.class);

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userDetails = inits.isInitialized("userDetails") ? new QUserDetails(forProperty("userDetails")) : null;
    }

}

