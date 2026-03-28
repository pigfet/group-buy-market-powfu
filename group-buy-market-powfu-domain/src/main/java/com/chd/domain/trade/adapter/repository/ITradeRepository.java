package com.chd.domain.trade.adapter.repository;

import com.chd.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.chd.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import com.chd.domain.trade.model.entity.GroupBuyActivityEntity;
import com.chd.domain.trade.model.entity.GroupBuyTeamEntity;
import com.chd.domain.trade.model.entity.MarketPayOrderEntity;
import com.chd.domain.trade.model.entity.NotifyTaskEntity;
import com.chd.domain.trade.model.valobj.GroupBuyProgressVO;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 交易仓储服务接口
 * @create 2025-01-11 09:07
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    boolean settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList();

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList(String teamId);

    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);

}
