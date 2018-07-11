package hzxtestmybatis.demo.dao;

import hzxtestmybatis.demo.model.User;

import java.util.List;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 18:07 2018/6/19
 * @Modify By:
 */
public interface UserDao {

    int insert(User record);

    List<User> selectUsers();
}
