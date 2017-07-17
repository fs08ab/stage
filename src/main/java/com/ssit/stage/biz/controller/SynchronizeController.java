package com.ssit.stage.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssit.stage.biz.service.SynchronizeService;
import com.ssit.stage.common.constant.StandardResult;
import com.ssit.stage.common.exception.BaseException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 同步统计数据
 *
 * @author Fs
 * @since 2017/7/17 11:57
 */
@RestController
public class SynchronizeController {
    private static final Log LOGGER = LogFactory.getLog(SynchronizeController.class);

    @Autowired
    private SynchronizeService synchronizeService;

    @ResponseBody
    @RequestMapping("/synchronize_date")
    public String synchronizeDate() {
        StandardResult standardResult;
        try {
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            synchronizeService.syncBuildingTable();
            synchronizeService.syncPartyBranchTable();
            synchronizeService.syncStatisticTable();
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }
}
