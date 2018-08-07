package com.jk.pojo;

import org.aspectj.weaver.ast.Test;
import org.springframework.boot.SpringBootConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/8/1 0001$ 8:49$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/8/1 0001$ 8:49$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootConfiguration
@Entity(name="lin_Role")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private Integer pid;


    @Transient
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

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

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", checked=" + checked +
                '}';
    }
}
