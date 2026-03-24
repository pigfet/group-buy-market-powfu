package com.chd.domain.activity.service.discount;

import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

public interface IDiscountCalculateService {
    /**
     * 计算用户在拼团活动中的折扣价格,顶层接口
     * @param userId
     * @param originalPrice
     * @return
     */
    BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}
