package com.yy.emp.service.user;

import com.yy.emp.api.IUserService;
import com.yy.emp.dao.mapper.UserMapper;
import com.yy.emp.model.User;
import com.yy.emp.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tuz
 * on 2020/5/15.
 */
@Service
public class UserService extends BaseService implements IUserService {

    @Override
    @Transactional
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional
    public void updatePwd(Integer id, String newPwd) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setPassword(newPwd);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> list() {
        return userMapper.selectByExample(null);
    }
}
