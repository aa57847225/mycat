package cn.no7player.mapper;

import cn.no7player.model.User;
import cn.no7player.model.Users;
import cn.no7player.model.UsersInfo;

/**
 * Created by zl on 2015/8/27.
 */
public interface UsersMapper {

    public void addUsers(Users users);

    public UsersInfo queryUsersInfo(Users users);

    public void updateUsers(Users users);
}
