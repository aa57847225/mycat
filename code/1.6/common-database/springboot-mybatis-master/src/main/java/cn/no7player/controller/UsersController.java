package cn.no7player.controller;

import cn.no7player.model.Users;
import cn.no7player.model.UsersInfo;
import cn.no7player.service.UserService;
import cn.no7player.service.UsersService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UsersController {

    private Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    /**

     {
     "comId":2,
     "name":"周兰",
     "sex":1
     }

     * @param users
     * @return
     */
    @RequestMapping(value = "/addUsers",method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public boolean addUsers(@RequestBody Users users) {
        try{
            System.out.println(users);
            return usersService.addUsers(users);
        }catch (Exception e){
            System.out.println("===========error========================"+e.getMessage());
            return false;
        }
    }


    /**

     {
     "id":15,
     "comId":2
     }

     * @param users
     * @return
     */
    @RequestMapping(value = "/getUsersInfoByComIdAndUserId",method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String getUsersByComIdAndUserId(@RequestBody Users users) {
        try{
            System.out.println(users);
            UsersInfo usersInfo= usersService.getUsersInfo(users);
            System.out.println(usersInfo);
            return JSON.toJSONString(usersInfo);
        }catch (Exception e){
            System.out.println("===========error========================"+e.getMessage());
            return null;
        }
    }





    /**
     * 测试多数据库事务
     * @param
     * @return
     */
    @RequestMapping(value = "/testUserTransaction",method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    @Transactional
    public String testUserTransaction() {
        try{
            usersService.testUserTransaction();
            return JSON.toJSONString("ok");
        }catch (Exception e){
            System.out.println("===========error========================"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }
}
