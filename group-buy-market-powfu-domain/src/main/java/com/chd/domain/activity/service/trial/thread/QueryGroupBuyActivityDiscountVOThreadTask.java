package com.chd.domain.activity.service.trial.thread;

import com.chd.domain.activity.adapter.repository.IActivityRepository;
import com.chd.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.util.concurrent.Callable;

/**
 * @className: QueryGroupBuyActivityDiscountVOThreadTask
 * @author: powfu
 * @date: 16/12/2025 下午10:10
 * @Version: 1.0
 * @description:
 */
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String source;

    private final String channel;

    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return activityRepository.queryGroupBuyActivityDiscount(source, channel);
    }
}
