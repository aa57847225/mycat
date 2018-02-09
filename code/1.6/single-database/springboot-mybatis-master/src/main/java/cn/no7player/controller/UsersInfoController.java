package cn.no7player.controller;

import cn.no7player.common.tenant.TenantContextHolder;
import cn.no7player.model.User;
import cn.no7player.model.UsersInfo;
import cn.no7player.service.UserService;
import cn.no7player.service.UsersInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UsersInfoController {

    private Logger logger = Logger.getLogger(UsersInfoController.class);

    @Autowired
    private UsersInfoService usersInfoService;

    /**
     api http://localhost:8080/getUsersInfo?tenant=db4
     tenant 切面注入  首先控制器拦截器  mybatis拦截器
     * @return
     */
    @RequestMapping("/getUsersInfo")
    @ResponseBody
    public UsersInfo getUserInfo() {
        //TenantContextHolder.setTenant("db4");
        UsersInfo usersInfo = usersInfoService.getUserInfo();
        if(usersInfo!=null){
            System.out.println("user.getName():"+usersInfo.getName());
            logger.info("info-======================================user.getAge():"+usersInfo.getName());
        }
        return usersInfo;
    }


    @RequestMapping("/testTransaction")
    @ResponseBody
    public boolean testTransaction() {
        boolean isAdd = false;
        try {
            isAdd = usersInfoService.updateMore();
        }catch (Exception e){
            isAdd = false;
            System.out.println("error "+e.getMessage());
        }
        return isAdd;
    }
}
