package cn.no7player.mapper;

import cn.no7player.model.Commodity;

import java.util.List;

/**
 * Created by whl on 2015/8/27.
 */
public interface CommodityMapper {

    /**
     * 查询商品
     *
     * @param id
     * @return
     */
    Commodity findCommodity(int id);

    /**
     * 添加商品
     *
     * @param commodity
     */
    void addCommodity(Commodity commodity);

    /**
     * 修改商品
     *
     * @param commodity
     */
    void updateCommodity(Commodity commodity);

//    /**
//     * 删除商品
//     *
//     * @param id
//     */
//    void deleteCommodity(int id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Commodity> findAll();
}
