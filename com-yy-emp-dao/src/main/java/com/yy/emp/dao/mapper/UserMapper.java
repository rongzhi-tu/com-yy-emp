package com.yy.emp.dao.mapper;

import com.yy.base.common.mybatisframe.PojoExample;
import com.yy.emp.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper {
    long countByExample(PojoExample example);

    int deleteByExample(PojoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(PojoExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") PojoExample example);

    int updateByExample(@Param("record") User record, @Param("example") PojoExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}