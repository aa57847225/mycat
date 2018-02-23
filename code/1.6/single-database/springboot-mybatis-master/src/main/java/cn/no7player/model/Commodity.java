package cn.no7player.model;

import java.math.BigDecimal;

/**
 * 商品表
 */
public class Commodity {

    // 主键
    private long id;

    // 商品名称
    private String name;

    // 售价
    private BigDecimal price;

    // 折扣价
    private BigDecimal discountPrice;

    // 状态
    private String status;

    // 商品描述
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
