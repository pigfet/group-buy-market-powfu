package com.chd.domain.tag.service;

/**
 * @className: ITagService
 * @author: powfu
 * @date: 25/3/2026 下午4:11
 * @Version: 1.0
 * @description:
 */
public interface ITagService {

    /**
     * 执行人群标签批次任务
     *
     * @param tagId
     * @param batchId
     */
    void execTagBatchJob(String tagId, String batchId);
}
