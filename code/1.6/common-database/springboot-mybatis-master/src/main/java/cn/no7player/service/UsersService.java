package cn.no7player.service;

import cn.no7player.mapper.UsersMapper;
import cn.no7player.model.Users;
import cn.no7player.model.UsersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public boolean addUsers(Users users){

        boolean isAdd = false;
        try {
            usersMapper.addUsers(users);
            isAdd = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isAdd;
    }

    public UsersInfo getUsersInfo(Users users){
        return usersMapper.queryUsersInfo(users);
    }

    public void testUserTransaction(){
        Users users = new Users();
        users.setName("李海2");
        users.setId(12);
        users.setComId(1);
        usersMapper.updateUsers(users);

//        int aa = 10/0;

        Users users1 = new Users();
        users1.setName("张力1");
        users1.setId(12);
        users1.setComId(2);
        usersMapper.updateUsers(users1);
    }

}
