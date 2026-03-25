package com.chd.domain.tag.service;

import com.chd.domain.tag.adapter.repository.ITagRepository;
import com.chd.domain.tag.model.entity.CrowdTagsJobEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: TagService
 * @author: powfu
 * @date: 25/3/2026 下午4:11
 * @Version: 1.0
 * @description:
 */
@Slf4j
@Service
public class TagService implements ITagService {

    @Resource
    private ITagRepository repository;

    @Override
    public void execTagBatchJob(String tagId, String batchId) {
        log.info("执行人群标签批次任务，tagId(标签ID)：{}，batchId(批次ID)：{}", tagId, batchId);

        // 1. 查询批次任务
        CrowdTagsJobEntity crowdTagsJobEntity = repository.queryCrowdTagsJobEntity(tagId, batchId);

        // 2. 采集用户数据 - 这部分需要采集用户的消费类数据，后续有用户发起拼单后再处理
        // todo

        // 3. 数据写入记录
        List<String> userIdList =  new ArrayList<>();
        userIdList.add("pcx");
        userIdList.add("pcy");

        // 4. 一般人群标签的处理在公司中，会有专门的数据仓团队通过脚本方式写入到数据库，就不用这样一个个或者批次来写
        for(String userId : userIdList) {
            repository.addCrowdTagsUserId(tagId, userId);
        }

        // 5. 更新人群标签统计量
        repository.updateCrowdTagsStatistics(tagId, userIdList.size());
    }
}
