package cn.no7player.service;

import cn.no7player.mapper.UsersMapper;
import cn.no7player.model.Users;
import cn.no7player.model.UsersDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UsersService {

    private Logger logger = Logger.getLogger(UsersService.class);

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询用户基本信息
     * @param id
     * @return
     */
    public Users getUserInfo(int id){
        Users user=usersMapper.findUser(id);
        return user;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean addUser(Users user){
        boolean isAdd = false;
        try {
            usersMapper.addUser(user);
            isAdd = true;
        }catch (Exception e){
            logger.info("=====添加失败====="+e.getMessage());
        }
        return isAdd;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public boolean updateUser(Users user){
        boolean isUpdate = false;
        try {
            usersMapper.updateUser(user);
            isUpdate = true;
        }catch (Exception e){
            logger.info("=====添加失败====="+e.getMessage());
        }
        return isUpdate;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    public List<Users> findAll(){
        List<Users> usersList=usersMapper.findAll();
        return usersList;
    }

    /**
     * 根据用户id查询用户详情
     * @param id
     * @return
     */
    public UsersDetail findUserDetail(int id){
        return usersMapper.findUserDetail(id);
    }

}
