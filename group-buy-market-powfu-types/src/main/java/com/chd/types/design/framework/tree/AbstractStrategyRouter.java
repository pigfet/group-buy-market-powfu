package com.chd.types.design.framework.tree;

/**
 * @className: AbstractStrategyRouter
 * @author: powfu
 * @date: 13/12/2025 下午8:22
 * @Version: 1.0
 * @description:
 */
public abstract class AbstractStrategyRouter <T, D, R> implements StrategyHandler<T, D, R>, StrategyMapper<T, D, R>{

    StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R route(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);

        if(null != strategyHandler){
            return defaultStrategyHandler.apply(requestParameter, dynamicContext);
        }

        return strategyHandler.apply(requestParameter, dynamicContext);
    }

}
