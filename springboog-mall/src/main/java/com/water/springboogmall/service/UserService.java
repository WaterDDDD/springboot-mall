package com.water.springboogmall.service;

import com.water.springboogmall.dto.UserLoginRequest;
import com.water.springboogmall.dto.UserRequest;
import com.water.springboogmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRequest userRequest);

    User login(UserLoginRequest userLoginRequest);
}
