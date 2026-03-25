package com.chd.infrastructure.adapter.repository;

import com.chd.domain.tag.adapter.repository.ITagRepository;
import com.chd.domain.tag.model.entity.CrowdTagsJobEntity;
import com.chd.infrastructure.dao.ICrowdTagsDao;
import com.chd.infrastructure.dao.ICrowdTagsDetailDao;
import com.chd.infrastructure.dao.ICrowdTagsJobDao;
import com.chd.infrastructure.dao.po.CrowdTags;
import com.chd.infrastructure.dao.po.CrowdTagsDetail;
import com.chd.infrastructure.dao.po.CrowdTagsJob;
import com.chd.infrastructure.redis.IRedisService;
import org.redisson.api.RBitSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @className: TagRepository
 * @author: powfu
 * @date: 25/3/2026 下午6:52
 * @Version: 1.0
 * @description: 人群标签仓储
 */
@Repository
public class TagRepository implements ITagRepository {

    @Resource
    private ICrowdTagsDao crowdTagsDao;
    @Resource
    private ICrowdTagsDetailDao crowdTagsDetailDao;
    @Resource
    private ICrowdTagsJobDao crowdTagsJobDao;

    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {
        CrowdTagsJob crowdTagsJobReq = new CrowdTagsJob();
        crowdTagsJobReq.setTagId(tagId);
        crowdTagsJobReq.setBatchId(batchId);

        CrowdTagsJob crowdTagsJobRes = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJobReq);
        if (null == crowdTagsJobRes) return null;

        return CrowdTagsJobEntity.builder()
                .tagType(crowdTagsJobRes.getTagType())
                .tagRule(crowdTagsJobRes.getTagRule())
                .statStartTime(crowdTagsJobRes.getStatStartTime())
                .statEndTime(crowdTagsJobRes.getStatEndTime())
                .build();
    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {
        CrowdTagsDetail crowdTagsDetailReq = new CrowdTagsDetail();
        crowdTagsDetailReq.setTagId(tagId);
        crowdTagsDetailReq.setUserId(userId);

        try {
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetailReq);

            // 获取BitSet
            RBitSet bitSet = redisService.getBitSet(tagId);
            bitSet.set(redisService.getIndexFromUserId(userId), true);
        } catch (Exception e) {
            // 忽略唯一索引冲突
        }
    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int count) {
        CrowdTags crowdTagsReq = new CrowdTags();
        crowdTagsReq.setTagId(tagId);
        crowdTagsReq.setStatistics(count);

        crowdTagsDao.updateCrowdTagsStatistics(crowdTagsReq);
    }
}
