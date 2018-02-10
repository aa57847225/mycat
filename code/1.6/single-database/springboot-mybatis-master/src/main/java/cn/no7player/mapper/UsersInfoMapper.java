package cn.no7player.mapper;

import cn.no7player.model.User;
import cn.no7player.model.UsersInfo;

/**
 * Created by zl on 2015/8/27.
 */
public interface UsersInfoMapper {

    //查询用户
    public UsersInfo findUsersInfo();

    //更新用户信息
    public void updateUserInfo();
}
