package cn.no7player.mapper;

import cn.no7player.model.UsersInfo;

/**
 * Created by whl on
 * 2018年2月23日14:01:40
 */
public interface UsersInfoMapper {

    /**
     * 查询用户
     * @return
     */
    UsersInfo findUsersInfo();

    /**
     * 更新用户信息
     */
    void updateUserInfo();
}
