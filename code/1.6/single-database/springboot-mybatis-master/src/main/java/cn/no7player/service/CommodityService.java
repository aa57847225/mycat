package cn.no7player.service;

import cn.no7player.constant.Project;
import cn.no7player.mapper.CommodityMapper;
import cn.no7player.model.Commodity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class CommodityService {

    private Logger logger = Logger.getLogger(CommodityService.class);

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    public Commodity getCommodity(int id){
        return commodityMapper.findCommodity(id);
    }

    /**
     * 添加商品信息
     * @param commodity
     * @return
     */
    public boolean addCommodity(Commodity commodity){
        boolean isAdd = false;
        try {
            commodityMapper.addCommodity(commodity);
            isAdd = true;
        }catch (Exception e){
            logger.info("=====添加失败====="+e.getMessage());
        }
        return isAdd;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    public boolean deleteCommodity(int id){
        boolean isUpdate = false;
        try {
            Commodity commodity = new Commodity();
            commodity.setId(id);
            commodity.setStatus(Project.COMMONDITY_DELETE);
            commodityMapper.updateCommodity(commodity);
            isUpdate = true;
        }catch (Exception e){
            logger.info("=====删除失败====="+e.getMessage());
        }
        return isUpdate;
    }


    /**
     * 修改商品信息
     * @param commodity
     * @return
     */
    public boolean updateCommodity(Commodity commodity){
        boolean isUpdate = false;
        try {
            commodityMapper.updateCommodity(commodity);
            isUpdate = true;
        }catch (Exception e){
            logger.info("=====修改失败====="+e.getMessage());
        }
        return isUpdate;
    }


    /**
     * 查询所有商品信息
     * @return
     */
    public List<Commodity> findAll(){
        List<Commodity> commodityList = commodityMapper.findAll();
        return commodityList;
    }
}
