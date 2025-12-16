package com.chd.infrastructure.dao;

import com.chd.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: ISku
 * @author: powfu
 * @date: 16/12/2025 下午8:31
 * @Version: 1.0
 * @description:
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);
}
