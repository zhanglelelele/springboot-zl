package com.jk.service;

import com.jk.pojo.*;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/7/31 0031$ 19:24$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/7/31 0031$ 19:24$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface IModelService {


    List<Developer> querylist(Developer developer);

    List<Usert> queryuser(Integer id);

    List<Usert> queryusesr();

    List<Role> queryrole();

    List<Permissions> querypermiss();

    void addUserRole(UserRole userRole);

    void addRolePermiss(RolePermiss permiss);

    void RolePermissdelete(String roleid);

    void deleteUserRole(String userid);

    List<Role> queryroless(Integer id);
}
