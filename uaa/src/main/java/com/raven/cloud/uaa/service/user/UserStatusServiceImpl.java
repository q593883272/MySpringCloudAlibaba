package com.raven.cloud.uaa.service.user;

import com.raven.cloud.uaa.dao.UserStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusServiceImpl extends UserStatusService {

    @Autowired
    public UserStatusServiceImpl(UserStatusDao userStatusDao) {
        super(userStatusDao);
    }


}
