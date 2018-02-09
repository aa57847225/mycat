package cn.no7player.service;

import cn.no7player.mapper.CompanyMapper;
import cn.no7player.mapper.UsersMapper;
import cn.no7player.model.Company;
import cn.no7player.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public boolean addCompany(Company company){

        boolean isAdd = false;
        try {
            companyMapper.addCompany(company);
            isAdd = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isAdd;
    }

}
