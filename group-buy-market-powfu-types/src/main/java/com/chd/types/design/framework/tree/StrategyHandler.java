package com.chd.types.design.framework.tree;

/**
 * @className: StrategyHandle
 * @author: powfu
 * @date: 13/12/2025 下午8:16
 * @Version: 1.0
 * @description:
 */
public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T, D) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;
}
