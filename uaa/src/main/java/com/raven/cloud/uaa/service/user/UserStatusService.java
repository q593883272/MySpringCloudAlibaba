package com.raven.cloud.uaa.service.user;

import com.raven.cloud.uaa.dao.UserStatusDao;
import com.raven.cloud.uaa.model.po.user.UserStatus;

public abstract class UserStatusService extends AbstractService<UserStatusDao, UserStatus, Integer> {

    protected UserStatusService(UserStatusDao userStatusDao) {
        super(userStatusDao, UserStatus.class);
    }

}
