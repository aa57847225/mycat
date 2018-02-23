package cn.no7player.mapper;

import cn.no7player.model.Company;

import java.util.List;

/**
 * Created by whl on
 * 2018年2月23日14:01:23
 */
public interface CompanyMapper {

    // 查询公司信息
    public Company findCompanyById(int id);

    // 添加公司
    public void addCompany(Company company);

    //修改公司信息
    public void updateCompany(Company company);

    //删除公司


    //查询所有公司信息
    public List<Company> findAllCompany();
}
