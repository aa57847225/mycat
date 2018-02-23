package cn.no7player.controller;

import cn.no7player.model.Company;
import cn.no7player.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    private Logger logger = Logger.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    /**
     * 根据公司id 查询公司信息
     * @param id
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public String getCompany(@RequestParam int id) {
        Company company = companyService.findCompanyById(id);
        if(company!=null){
            logger.info("====company========"+company.getName());
        }
        return JSON.toJSONString(company);
    }

    /**
     * 新增公司
     * @param company
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String addCompany(@RequestBody Company company) {
        boolean isAdd = false;
        try{
            isAdd = companyService.addCompany(company);
        }catch (Exception e){
            logger.info("====add error========"+e.getMessage());
        }
        return JSON.toJSONString(isAdd);
    }

    /**
     * 修改公司信息
     * @param company
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String updateCompany(@RequestBody Company company) {
        boolean isUpdate = false;
        try {
            isUpdate = companyService.updateCompany(company);
        }catch (Exception e){
            logger.info("====update error========"+e.getMessage());
        }
        return JSON.toJSONString(isUpdate);
    }

    /**
     * 查询所有公司信息
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public String findAll() {
        List<Company> companyList = companyService.findAllCompany();
        return JSON.toJSONString(companyList);
    }
}
