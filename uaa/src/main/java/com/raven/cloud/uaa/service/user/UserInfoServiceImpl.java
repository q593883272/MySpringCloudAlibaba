package com.raven.cloud.uaa.service.user;

import com.raven.cloud.uaa.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends UserInfoService {

    @Autowired
    public UserInfoServiceImpl(UserInfoDao userInfoDao) {
        super(userInfoDao);
    }

}
