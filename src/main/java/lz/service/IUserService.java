package lz.service;

import lz.annotation.Transactional;
import lz.domain.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> getAllUser();


    User GetUserInfoById(Integer id);

    @Transactional
    boolean updateUser(int id, Map<String, Object> fieldMap);
}
