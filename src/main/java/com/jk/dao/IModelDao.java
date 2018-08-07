package com.jk.dao;

import com.jk.pojo.*;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/7/31 0031$ 19:40$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/7/31 0031$ 19:40$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
    @Mapper
public interface IModelDao {
    @Select(" select * from lin_users where pid= #{id}  ")
    List<Usert> queryuser(Integer id);

    @Select(" select * from lin_users  ")
    List<Usert> queryusesr();

    @Select(" select * from t_roletree  ")
    List<Role> queryrole();

    @Select(" select * from t_jurtree  ")
    List<Permissions> querypermiss();

    @Insert("INSERT into lin_user_role(userid,roleid) values(#{userRole.userid},#{userRole.roleid}) ")
    void addUserRole(@Param("userRole") UserRole userRole);

    @Insert("INSERT into lin_role_permiss(roleid,Permissid) values(#{permiss.roleid},#{permiss.Permissid}) ")
    void addRolePermiss(@Param("permiss") RolePermiss permiss);

    @Delete(" delete from lin_user_role where userid in (${userid})")
    void delete(@Param("userid") String userid);

    @Delete(" delete from lin_role_permiss where userid in (${userid})")
    void RolePermissdelete(@Param("userid") String roleid);

    @Select(" select * from lin_user_role where userid = #{id} ")
    List<UserRole> queryroless(@Param("id") Integer id);

//    @Modifying
//    @Query("select  u from Usert u  where u.pid = :id")
//    List<Usert> queryuser(@Param("id") Integer id);



}
