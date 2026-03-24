package com.chd.domain.activity.service.discount.impl;

import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.chd.domain.activity.service.discount.AbstractDiscountCalculateService;
import com.chd.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @className: MJCalculateService
 * @author: powfu
 * @date: 24/3/2026 下午5:29
 * @Version: 1.0
 * @description:
 */
@Slf4j
@Service("MJ")
public class MJCalculateService extends AbstractDiscountCalculateService {

    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        log.info("优惠策略折扣计算:{}", groupBuyDiscount.getDiscountType().getInfo());

        // 折扣表达式 - 100,10 满100减10元
        String marketExpr = groupBuyDiscount.getMarketExpr();
        String[] split = marketExpr.split(Constants.SPLIT);
        BigDecimal x = new BigDecimal(split[0]);
        BigDecimal y = new BigDecimal(split[1]);

        // 不满足最低满减约束，则按照原价
        if(originalPrice.compareTo(x) < 0){
            return originalPrice;
        }

        // 折扣价格
        BigDecimal deductionPrice = originalPrice.subtract(y);

        // 判断折扣后金额,最低不能小于0
        if(deductionPrice.compareTo(BigDecimal.ZERO) <= 0){
            return new BigDecimal(0);
        }

        return deductionPrice;
    }
}
