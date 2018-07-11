package hzxtestmybatis.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzxtestmybatis.demo.dao.UserDao;
import hzxtestmybatis.demo.model.User;
import hzxtestmybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 18:16 2018/6/19
 * @Modify By:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}
