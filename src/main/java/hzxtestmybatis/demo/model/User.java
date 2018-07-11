package hzxtestmybatis.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 18:06 2018/6/19
 * @Modify By:
 */
@Data
@Entity
@Table(name = "t_user")
public class User{
    private Integer userId;

    private String userName;

    private String password;

    private String phone;
}
