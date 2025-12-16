package com.chd.domain.activity.service.trial.thread;

import com.chd.domain.activity.adapter.repository.IActivityRepository;
import com.chd.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * @className: QuerySkuVOFromDBThreadTask
 * @author: powfu
 * @date: 16/12/2025 下午10:17
 * @Version: 1.0
 * @description:
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String skuId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String skuId, IActivityRepository activityRepository) {
        this.skuId = skuId;
        this.activityRepository = activityRepository;
    }
    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(skuId);
    }
}
