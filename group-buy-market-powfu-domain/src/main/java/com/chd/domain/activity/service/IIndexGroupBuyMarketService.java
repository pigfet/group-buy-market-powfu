package com.chd.domain.activity.service;

import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @className: IIndexGroupBuyMarketService
 * @author: powfu
 * @date: 13/12/2025 下午8:44
 * @Version: 1.0
 * @description:
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;
}
