package com.jk.pojo;

import org.springframework.boot.SpringBootConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/8/1 0001$ 8:51$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/8/1 0001$ 8:51$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootConfiguration
@Entity(name="lin_permissions")
public class Permissions {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Usert{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                '}';
    }
}
