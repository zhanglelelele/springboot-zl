package com.jk.pojo;

import org.springframework.boot.SpringBootConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 尹修旭
 * @CreateDate: 2018/8/1 0001$ 8:46$
 * @UpdateUser: 尹修旭
 * @UpdateDate: 2018/8/1 0001$ 8:46$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootConfiguration
@Entity(name="lin_user")
public class Usert {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private Integer pid;
    @Transient
    private List<Usert>  list ;
    @Transient
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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

    public List<Usert> getList() {
        return list;
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

    public void setList(List<Usert> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Usert{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", list=" + list +
                ", checked=" + checked +
                '}';
    }
}
