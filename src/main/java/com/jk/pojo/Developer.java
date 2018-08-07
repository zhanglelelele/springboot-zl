package com.jk.pojo;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;


/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/7/31 0031$ 16:07$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/7/31 0031$ 16:07$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootConfiguration
@Entity(name="lin_user")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;
    private String sname;
    private String svalue;

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSvalue() {
        return svalue;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", svalue='" + svalue + '\'' +
                '}';
    }
}
