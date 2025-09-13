package com.water.springboogmall.service.Impl;


import com.water.springboogmall.dao.UserDao;
import com.water.springboogmall.dto.UserLoginRequest;
import com.water.springboogmall.dto.UserRequest;
import com.water.springboogmall.model.User;
import com.water.springboogmall.service.UserService;
import com.water.springboogmall.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {

        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRequest userRequest) {


        // 檢查註冊 email
        User user = userDao.gerUserByEmail(userRequest.getEmail());

        if(user != null) {
            log.warn("該 email {} 已經被註冊", userRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 創建帳號
        return userDao.createUser(userRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.gerUserByEmail(userLoginRequest.getEmail());

        if(user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (user.getPassword().equals(userLoginRequest.getPassword())) {
            return user;
        } else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
