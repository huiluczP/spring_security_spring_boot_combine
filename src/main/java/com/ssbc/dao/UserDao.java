package com.ssbc.dao;

import com.ssbc.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface UserDao{
    @Select(
            "select * from user" +
                    " where username = #{username}"
    )
    @Results(
            {
                    @Result(id=true, column="user_id", property="user_id"),
                    @Result(property="username", column="username"),
                    @Result(property="password", column="password"),
                    @Result(property="email", column="email"),
                    @Result(property="roles", column="username",
                        many=@Many(
                                select="com.ssbc.dao.RoleDao.getRolesByUsername",
                                fetchType= FetchType.LAZY
                        ))
            }
    )
    User getUserByName(String username);
}
