package com.chd.domain.activity.service;

import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;
import com.chd.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.chd.types.design.framework.tree.StrategyHandler;

import javax.annotation.Resource;

/**
 * @className: IIndexGroupBuyMarketServiceImpl
 * @author: powfu
 * @date: 13/12/2025 下午8:45
 * @Version: 1.0
 * @description:
 */
public class IIndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private DefaultActivityStrategyFactory activityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {

        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = activityStrategyFactory.strategyHandler();

        TrialBalanceEntity trialBalanceEntity = strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());

        return trialBalanceEntity;
    }
}
