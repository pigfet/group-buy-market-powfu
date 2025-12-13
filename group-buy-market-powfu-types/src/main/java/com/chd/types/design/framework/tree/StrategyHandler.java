package com.chd.types.design.framework.tree;

/**
 * @className: StrategyHandle
 * @author: powfu
 * @date: 13/12/2025 下午8:16
 * @Version: 1.0
 * @description:
 */
public interface StrategyHandler<T, D, R> {

    //StrategyHandler DEFAULT = new StrategyHandler() {
    //    @Override
    //    public Object handle(Object requestParameter, Object dynamicContext) throws Exception {
    //        return null;
    //    }
    //};
    StrategyHandler DEFAULT = (requestParameter, dynamicContext) -> null;  //默认处理器，什么都不干
    R apply(T requestParameter, D dynamicContext) throws Exception;

}
