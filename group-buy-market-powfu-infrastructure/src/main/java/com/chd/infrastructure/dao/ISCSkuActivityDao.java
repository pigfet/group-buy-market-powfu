package com.chd.infrastructure.dao;

import com.chd.infrastructure.dao.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: ISCSkuActivity
 * @author: powfu
 * @date: 26/3/2026 下午12:43
 * @Version: 1.0
 * @description:
 */
@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);

}
