package com.jk.controller;

import com.jk.pojo.*;
import com.jk.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;


/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/7/31 0031$ 17:03$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/7/31 0031$ 17:03$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
    @Controller
    @RequestMapping(value = "/con")
    public class ModelController {
    @Autowired
    private IModelService modelService;



    @RequestMapping(value = "/test")
    public String  querytest(){
        System.out.println("lalalla");
        return  "index";
    }

    @RequestMapping(value = "/querylist")
    public  void  querylist(){
        Developer developer=new Developer();
        developer.setSname("longlong");
        developer.setSvalue("asdasjhdasjhk");
      List<Developer> list= modelService.querylist(developer);
        System.out.println(list);
    }

   @RequestMapping("/queryuser")
   @ResponseBody
    public  List<Usert> queryuser(){
        Integer id=0;
        return getquerylist(id);
    }
    public   List<Usert> getquerylist(Integer id){
        List<Usert> list=modelService.queryuser(id);
        for (Usert usert : list) {
            Integer id1 = usert.getId();
            List<Usert> getquerylist = getquerylist(id1);
            usert.setList(getquerylist);
        }
        return  list;
    }

    @RequestMapping("/queryusers")
    @ResponseBody
    public   List<Usert> queryusesr(){
        List<Usert> list=modelService.queryusesr();

        return  list;
    }
    @RequestMapping("/queryrole")
    @ResponseBody
    public   List<Role> queryrole(){
        List<Role> list=modelService.queryrole();

        return  list;
    }
    @RequestMapping("/querypermiss")
    @ResponseBody
    public   List<Permissions> querypermiss(){
        List<Permissions> list=modelService.querypermiss();

        return  list;
    }
    @RequestMapping("/addUserRole")
    @ResponseBody
    public  String addUserRole(String userid, String roleid){
        String[] split = userid.split(",");
        String[] split1 = roleid.split(",");
        modelService.deleteUserRole(userid);
        UserRole userRole=new UserRole();
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split1.length; j++) {
                userRole.setUserid(split[i]);
                userRole.setRoleid(split1[j]);
                modelService.addUserRole(userRole);
            }
        }

        return "1";
    }

    @RequestMapping("/addRolePermiss")
    @ResponseBody
        public  String addRolePermiss(String roleid, String Permissid){
        String[] split = roleid.split(",");
        String[] split2 = Permissid.split(",");
        modelService.RolePermissdelete(roleid);
        RolePermiss permiss=new RolePermiss();
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split2.length; j++) {
                permiss.setRoleid(split[i]);
                permiss.setPermissid(split2[j]);
                modelService.addRolePermiss(permiss);
            }
        }
        return "1";
    }
    @RequestMapping("/queryroless")
    @ResponseBody
    public List<Role> queryroless(Integer id){
        List<Role> list=modelService.queryroless(id);
    return list;
    }




}
