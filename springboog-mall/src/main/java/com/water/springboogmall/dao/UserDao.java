package com.water.springboogmall.dao;


import com.water.springboogmall.dto.UserRequest;
import com.water.springboogmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRequest userRequest);
}
