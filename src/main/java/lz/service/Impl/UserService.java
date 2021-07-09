package lz.service.Impl;

import lz.annotation.Autowired;
import lz.annotation.Service;
import lz.annotation.Transactional;
import lz.domain.User;
import lz.helper.DatabaseHelper;
import lz.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserService implements IUserService {
    /**
     * 获取所有用户
     */
    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        return DatabaseHelper.queryEntityList(User.class, sql);
    }

    /**
     * 根据id获取用户信息
     */
    @Override
    public User GetUserInfoById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return DatabaseHelper.queryEntity(User.class, sql, id);
    }

    /**
     * 修改用户信息
     */
    @Transactional
    @Override
    public boolean updateUser(int id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(User.class, id, fieldMap);
    }
}
