package com.ssbc.dao;

import com.ssbc.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select role_id, role_name from role_type where role_id = #{role_id}")
    Role getRoleById(int role_id);

    @Select(            " select r.*\n" +
                        "from role_type r\n" +
                        "right join role_user_role rur\n" +
                        "on r.role_id = rur.role_id\n" +
                        "right join role_user u\n" +
                        "on u.user_id = rur.user_id\n" +
                        "where username = #{username}"
    )
    public List<Role> getRolesByUsername(String username);
}
