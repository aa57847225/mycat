package cn.no7player.controller;

import cn.no7player.model.Users;
import cn.no7player.model.UsersDetail;
import cn.no7player.service.UsersService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    private Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    /**
     * 查询用户基本信息
     * @param id
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public String getUser(@RequestParam int id) {
        Users user = usersService.getUserInfo(id);
        if(user!=null){
            logger.info("====company========"+user.getName());
        }
        return JSON.toJSONString(user);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String addUser(@RequestBody Users user) {
        boolean isAdd = false;
        try{
            isAdd = usersService.addUser(user);
        }catch (Exception e){
            logger.info("======添加失败======="+e.getMessage());
        }
        return JSON.toJSONString(isAdd);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String updateUser(@RequestBody Users user) {
        boolean isUpdate = false;
        try{
            isUpdate = usersService.updateUser(user);
        }catch (Exception e){
            logger.info("======添加失败======="+e.getMessage());
        }
        return JSON.toJSONString(isUpdate);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public String findAll() {
        List<Users> usersList = usersService.findAll();
        return JSON.toJSONString(usersList);
    }

    /**
     * 查询用户详情
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public String getUserDetail(@RequestParam int id) {
        UsersDetail user = usersService.findUserDetail(id);
        if(user!=null){
            logger.info("====user========"+user.getName());
        }
        return JSON.toJSONString(user);
    }
}
