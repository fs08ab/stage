package com.ssit.stage.biz.service;

/**
 * 同步统计数据
 *
 * @author Fs
 * @since 2017/7/17 11:53
 */
public interface SynchronizeService {
    void syncBuildingTable();

    void syncPartyBranchTable();

    void syncStatisticTable();
}
