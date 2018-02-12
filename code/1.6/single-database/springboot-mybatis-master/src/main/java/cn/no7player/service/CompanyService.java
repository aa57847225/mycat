package cn.no7player.service;

import cn.no7player.mapper.CompanyMapper;
import cn.no7player.model.Company;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class CompanyService {

    private Logger logger = Logger.getLogger(CompanyService.class);

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 查询公司信息
     * @param id
     * @return
     */
    public Company findCompanyById(int id){
        return companyMapper.findCompanyById(id);
    }

    /**
     * 添加公司
     * @param company
     * @return
     */
    public boolean addCompany(Company company){
        boolean isAdd = false;
        try {
            companyMapper.addCompany(company);
            isAdd = true;
        }catch (Exception e){
            logger.info("=====添加失败====="+e.getMessage());
        }
        return isAdd;
    }

    /**
     * 修改公司信息
     * @param company
     * @return
     */
    public boolean updateCompany(Company company){
        boolean isUpdate = false;
        try {
            companyMapper.updateCompany(company);
            isUpdate = true;
        }catch (Exception e){
            logger.info("=====添加失败====="+e.getMessage());
        }
        return isUpdate;
    }

    //删除公司


    /**
     * 查询所有公司信息
     * @return
     */
    public List<Company> findAllCompany(){
        return companyMapper.findAllCompany();
    }

}
