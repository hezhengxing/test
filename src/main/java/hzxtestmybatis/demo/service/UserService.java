package hzxtestmybatis.demo.service;

import com.github.pagehelper.PageInfo;
import hzxtestmybatis.demo.model.User;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 18:15 2018/6/19
 * @Modify By:
 */
public interface UserService {
    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
