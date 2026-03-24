package com.chd.domain.activity.service.discount;

import com.chd.domain.activity.model.valobj.DiscountTypeEnum;
import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @className: AbstractDiscountCalculateService
 * @author: powfu
 * @date: 24/3/2026 下午5:02
 * @Version: 1.0
 * @description:
 */
public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService {


    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        // 1. 人群标签过滤
        if(DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if(!isCrowRange) return originalPrice;
        }
        // 2. 折扣优惠计算
        return doCalculate(originalPrice, groupBuyDiscount);
    }

    // 人群过滤 - 限定人群优惠
    private boolean filterTagId(String userId, String tagId) {
        // todo
        return true;
    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);
}
