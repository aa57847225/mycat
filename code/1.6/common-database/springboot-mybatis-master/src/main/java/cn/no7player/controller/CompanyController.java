package cn.no7player.controller;

import cn.no7player.model.Company;
import cn.no7player.model.Users;
import cn.no7player.service.CompanyService;
import cn.no7player.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class CompanyController {

    private Logger logger = Logger.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    /**
     {
     "id":3,
     "name":"江苏苏美达轻纺国际贸易有限公司"
     }
     * @param company
     * @return
     */
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public boolean addCompany(@RequestBody Company company) {
        System.out.println(company);
        return companyService.addCompany(company);
    }

}
