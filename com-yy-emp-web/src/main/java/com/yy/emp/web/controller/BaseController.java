package com.yy.emp.web.controller;

import com.yy.emp.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tuz
 * on 2020/5/15.
 */
public class BaseController {
    @Autowired
    protected IUserService userService;
}
