package com.zw.springboot.service.impl;

import com.zw.springboot.bean.User;
import com.zw.springboot.dao.UserDao;
import com.zw.springboot.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwzw
 * @since 2018-08-28
 */
@Service(value = "userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
