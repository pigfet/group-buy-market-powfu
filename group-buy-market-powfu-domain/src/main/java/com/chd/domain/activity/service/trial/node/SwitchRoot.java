package com.chd.domain.activity.service.trial.node;

import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;
import com.chd.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.chd.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.chd.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @className: SwitchRoot
 * @author: powfu
 * @date: 13/12/2025 下午8:49
 * @Version: 1.0
 * @description:
 */
@Slf4j
@Service
public class SwitchRoot extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private MarketNode marketNode;

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return route(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity marketProductEntity, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return marketNode;
    }
}
