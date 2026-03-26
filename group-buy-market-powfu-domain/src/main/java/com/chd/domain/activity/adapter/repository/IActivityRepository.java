package com.chd.domain.activity.adapter.repository;

import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.chd.domain.activity.model.valobj.SCSkuActivityVO;
import com.chd.domain.activity.model.valobj.SkuVO;

/**
 * @className: IActivityRepository
 * @author: powfu
 * @date: 16/12/2025 下午9:19
 * @Version: 1.0
 * @description:
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);
}
