package cn.no7player.mapper;

import cn.no7player.model.Users;
import cn.no7player.model.UsersDetail;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
public interface UsersMapper {

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    Users findUser(int id);

    /**
     * 添加用户
     * @param user
     */
    void addUser(Users user);

    /**
     * 删除用户
     * @param user
     */
    void updateUser(Users user);

    /**
     * 查询所有
     * @return
     */
    List<Users> findAll();

    /**
     * 根据ID 查询用户详情
     * @param id
     * @return
     */
    UsersDetail findUserDetail(int id);
}
