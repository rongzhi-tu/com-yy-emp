package com.yy.emp.api;

import com.yy.emp.model.User;

import java.util.List;

/**
 * Created by tuz
 * on 2020/5/14.
 */
public interface IUserService {
    //用户注册
    void register(User user);
    //用户信息查看
    User get(Integer id);
    //用户信息修改
    void update(User user);
    // 密码修改
    void updatePwd(Integer id,String newPwd);
    //列表显示
    List<User> list();
}
