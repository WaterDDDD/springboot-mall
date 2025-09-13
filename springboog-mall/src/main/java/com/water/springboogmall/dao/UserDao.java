package com.water.springboogmall.dao;


import com.water.springboogmall.dto.UserRequest;
import com.water.springboogmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User gerUserByEmail(String email);

    Integer createUser(UserRequest userRequest);
}
