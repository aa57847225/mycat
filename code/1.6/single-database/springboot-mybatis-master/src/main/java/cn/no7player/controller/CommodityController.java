package cn.no7player.controller;

import cn.no7player.model.Commodity;
import cn.no7player.service.CommodityService;
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
@RequestMapping("/commodity")
public class CommodityController {

    private Logger logger = Logger.getLogger(CommodityController.class);

    @Autowired
    private CommodityService commodityService;

    /**
     * 根据ID查询商品信息
     * @param id
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public String getCommodity(@RequestParam int id) {
        Commodity commodity = commodityService.getCommodity(id);
        if(commodity!=null){
            logger.info("====company========"+commodity.getName());
        }
        return JSON.toJSONString(commodity);
    }

    /**
     * 新增商品
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String addCommodity(@RequestBody Commodity commodity) {
        boolean isAdd = false;
        try{
            isAdd = commodityService.addCommodity(commodity);
        }catch (Exception e){
            logger.info("====add error========"+e.getMessage());
        }
        return JSON.toJSONString(isAdd);
    }

    /**
     * 修改商品信息
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String updateCommodity(@RequestBody Commodity commodity) {
        boolean isUpdate = false;
        try {
            isUpdate = commodityService.updateCommodity(commodity);
        }catch (Exception e){
            logger.info("====update error========"+e.getMessage());
        }
        return JSON.toJSONString(isUpdate);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String deleteCommodity(@RequestParam int id) {
        boolean isUpdate = false;
        try {
            isUpdate = commodityService.deleteCommodity(id);
        }catch (Exception e){
            logger.info("====update error========"+e.getMessage());
        }
        return JSON.toJSONString(isUpdate);
    }

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public String findAll() {
        List<Commodity> commodityList = commodityService.findAll();
        return JSON.toJSONString(commodityList);
    }
}
