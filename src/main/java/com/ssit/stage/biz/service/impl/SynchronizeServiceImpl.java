package com.ssit.stage.biz.service.impl;

import com.ssit.stage.biz.dao.SynchronizeMapper;
import com.ssit.stage.biz.service.SynchronizeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 同步统计数据
 *
 * @author Fs
 * @since 2017/7/17 11:54
 */
@Service("synchronizeService")
@Transactional
public class SynchronizeServiceImpl implements SynchronizeService {
    private static final Log LOGGER = LogFactory.getLog(SynchronizeService.class);

    private final SynchronizeMapper synchronizeMapper;

    @Autowired
    public SynchronizeServiceImpl(SynchronizeMapper synchronizeMapper) {
        this.synchronizeMapper = synchronizeMapper;
    }

    @Override
    public void syncBuildingTable() {
        int i = synchronizeMapper.syncBuildingTable();
        LOGGER.info("更新t_building表中党支部数量和党员数量成功，受影响数据量：" + i);
    }

    @Override
    public void syncPartyBranchTable() {
        int i = synchronizeMapper.syncPartyBranchTable();
        LOGGER.info("更新t_party_branch表中党员数量成功，受影响数据量：" + i);
    }

    @Override
    public void syncStatisticTable() {
        synchronizeMapper.truncateStatisticTable();
        int i = synchronizeMapper.syncStatisticTable();
        if (i <= 0) {
            LOGGER.warn("重新统计t_statistic表中数据时，新数据量为0");
        }
        LOGGER.warn("重新统计t_statistic表中数据完毕");
    }
}
