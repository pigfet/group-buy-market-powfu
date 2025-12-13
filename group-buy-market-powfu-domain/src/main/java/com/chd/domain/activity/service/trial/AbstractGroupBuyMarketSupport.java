package com.chd.domain.activity.service.trial;

import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;
import com.chd.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.chd.types.design.framework.tree.AbstractStrategyRouter;

/**
 * @className: AbstractGroupBuyMarketSupport
 * @author: powfu
 * @date: 13/12/2025 下午8:44
 * @Version: 1.0
 * @description:
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractStrategyRouter<com.chd.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.chd.domain.activity.model.entity.TrialBalanceEntity > {
}
