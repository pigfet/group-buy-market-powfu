package com.chd.domain.activity.service.trial.node;

import com.alibaba.fastjson.JSON;
import com.chd.domain.activity.model.entity.MarketProductEntity;
import com.chd.domain.activity.model.entity.TrialBalanceEntity;
import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.chd.domain.activity.model.valobj.SkuVO;
import com.chd.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.chd.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.chd.domain.activity.service.trial.thread.QueryGroupBuyActivityDiscountVOThreadTask;
import com.chd.domain.activity.service.trial.thread.QuerySkuVOFromDBThreadTask;
import com.chd.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @className: MarketNode
 * @author: powfu
 * @date: 13/12/2025 下午8:49
 * @Version: 1.0
 * @description:
 */
@Slf4j
@Service
public class MarketNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private EndNode endNode;
    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public void multiThreadRoute(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
        QueryGroupBuyActivityDiscountVOThreadTask queryGroupBuyActivityDiscountVOThreadTask = new QueryGroupBuyActivityDiscountVOThreadTask(requestParameter.getSource(), requestParameter.getChannel(), repository);
        FutureTask<GroupBuyActivityDiscountVO> futureTask = new FutureTask<>(queryGroupBuyActivityDiscountVOThreadTask);
        threadPoolExecutor.execute(futureTask);

        QuerySkuVOFromDBThreadTask querySkuVOFromDBThreadTask = new QuerySkuVOFromDBThreadTask(requestParameter.getGoodsId(), repository);
        FutureTask<SkuVO> skuVOFutureTask = new FutureTask<>(querySkuVOFromDBThreadTask);
        threadPoolExecutor.execute(skuVOFutureTask);

        dynamicContext.setGroupBuyActivityDiscountVO(futureTask.get(timeout, TimeUnit.MILLISECONDS));
        dynamicContext.setSkuVO(skuVOFutureTask.get(timeout, TimeUnit.MILLISECONDS));
        log.info("拼团商品查询试算服务-MarketNode userId:{} 异步线程加载数据「GroupBuyActivityDiscountVO、SkuVO」完成", requestParameter.getUserId());
    }

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-MarketNode userId:{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));

        // todo 优惠活动试算

        return route(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity marketProductEntity, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return endNode;
    }
}
