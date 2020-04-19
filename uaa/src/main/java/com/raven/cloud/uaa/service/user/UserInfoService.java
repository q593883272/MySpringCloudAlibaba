package com.raven.cloud.uaa.service.user;

import com.raven.cloud.common.service.BaseService;
import com.raven.cloud.uaa.dao.UserInfoDao;
import com.raven.cloud.uaa.model.po.user.UserInfo;

public abstract class UserInfoService extends AbstractService<UserInfoDao, UserInfo, Integer> {

    protected UserInfoService(UserInfoDao userInfoDao) {
        super(userInfoDao, UserInfo.class);
    }

}
