package com.chd.domain.activity.service;

import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;
import com.chd.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.chd.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @className: IIndexGroupBuyMarketServiceImpl
 * @author: powfu
 * @date: 13/12/2025 下午8:45
 * @Version: 1.0
 * @description:
 */
@Service
public class IIndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {
        // 获取执行策略
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();
        // 受理试算操作
        return strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());
    }
}
