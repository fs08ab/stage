package com.ssit.stage.biz.scheduler;

import com.ssit.stage.biz.service.SynchronizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步统计数据定时任务
 *
 * @author Fs
 * @since 2017/7/17 11:53
 */
@Component("syncDataJob")
public class SyncDataJob {

	private final SynchronizeService syncService;

	@Autowired
	public SyncDataJob(SynchronizeService syncService) {
		this.syncService = syncService;
	}

	public void execute() {
		syncService.syncBuildingTable();
		syncService.syncPartyBranchTable();
		syncService.syncStatisticTable();
	}
}
