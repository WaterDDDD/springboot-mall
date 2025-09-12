package com.water.springboogmall.service.Impl;


import com.water.springboogmall.dao.UserDao;
import com.water.springboogmall.dto.UserRequest;
import com.water.springboogmall.model.User;
import com.water.springboogmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRequest userRequest) {
        return userDao.createUser(userRequest);
    }
}
