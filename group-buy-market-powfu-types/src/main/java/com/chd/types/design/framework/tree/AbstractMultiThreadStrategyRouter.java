package com.chd.types.design.framework.tree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @className: AbstractMultiThreadStrategyRouter
 * @author: powfu
 * @date: 14/12/2025 下午7:57
 * @Version: 1.0
 * @description:
 */
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> implements StrategyHandler<T, D, R>, StrategyMapper<T, D, R> {

    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R route(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);

        if(null != strategyHandler){
            return defaultStrategyHandler.apply(requestParameter, dynamicContext);
        }

        return strategyHandler.apply(requestParameter, dynamicContext);
    }


    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {

        multiThreadRoute(requestParameter, dynamicContext);
        return doApply(requestParameter, dynamicContext);
    }

    public abstract void multiThreadRoute(T requestParameter, D dynamicContext) throws ExecutionException, InterruptedException, TimeoutException;

    public abstract R doApply(T requestParameter, D dynamicContext) throws Exception;
}
