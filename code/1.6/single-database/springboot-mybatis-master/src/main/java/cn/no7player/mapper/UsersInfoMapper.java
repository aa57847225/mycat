package cn.no7player.mapper;

import cn.no7player.model.User;
import cn.no7player.model.UsersInfo;

/**
 * Created by zl on 2015/8/27.
 */
public interface UsersInfoMapper {
    public UsersInfo findUsersInfo();

    public void updateUserInfo();
}
