package com.chd.domain.activity.service.trial.node;

import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;
import com.chd.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.chd.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.chd.types.design.framework.tree.StrategyHandler;

/**
 * @className: RootNode
 * @author: powfu
 * @date: 13/12/2025 下午8:49
 * @Version: 1.0
 * @description:
 */
public class RootNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Override
    public TrialBalanceEntity apply(MarketProductEntity marketProductEntity, DefaultActivityStrategyFactory.DynamicContext dynamicContext){
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity marketProductEntity, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return null;
    }
}
