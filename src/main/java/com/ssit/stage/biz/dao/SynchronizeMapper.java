package com.ssit.stage.biz.dao;

import org.springframework.stereotype.Repository;

/**
 * 同步统计数据
 *
 * @author Fs
 * @since 2017/7/17 10:46
 */
@Repository
public interface SynchronizeMapper {
    int syncBuildingTable();

    int syncPartyBranchTable();

    void truncateStatisticTable();

    int syncStatisticTable();
}
