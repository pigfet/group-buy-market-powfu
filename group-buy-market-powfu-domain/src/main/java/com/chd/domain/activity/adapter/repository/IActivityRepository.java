package com.chd.domain.activity.adapter.repository;

import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.chd.domain.activity.model.valobj.SkuVO;

/**
 * @className: IActivityRepository
 * @author: powfu
 * @date: 16/12/2025 下午9:19
 * @Version: 1.0
 * @description:
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscount(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);
}
