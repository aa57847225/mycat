package cn.no7player.service;

import cn.no7player.common.tenant.TenantContextHolder;
import cn.no7player.mapper.UsersInfoMapper;
import cn.no7player.model.UsersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UsersInfoService {

    @Autowired
    private UsersInfoMapper usersInfoMapper;

    public UsersInfo getUserInfo(){
        UsersInfo usersInfo=usersInfoMapper.findUsersInfo();
        return usersInfo;
    }

    @Transactional
    public boolean updateMore(){
        boolean isAdd = false;
        try{

            TenantContextHolder.setTenant("db6");
            usersInfoMapper.updateUserInfo();

            TenantContextHolder.setTenant("db4");
            usersInfoMapper.updateUserInfo();
            int a = 1/0;
            TenantContextHolder.setTenant("db5");
            usersInfoMapper.updateUserInfo();
            isAdd = true;
        }catch (Exception e){
            isAdd = false;
            throw new RuntimeException();
        }
        return  isAdd;
    }

}
