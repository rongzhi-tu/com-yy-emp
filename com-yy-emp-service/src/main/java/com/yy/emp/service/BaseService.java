package com.yy.emp.service;

import com.yy.emp.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tuz
 * on 2020/5/15.
 */
public class BaseService {
    @Autowired
    protected UserMapper userMapper;
}
