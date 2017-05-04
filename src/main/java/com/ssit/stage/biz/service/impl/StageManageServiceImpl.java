package com.ssit.stage.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssit.stage.biz.bean.po.*;
import com.ssit.stage.biz.bean.qo.ActivityQO;
import com.ssit.stage.biz.bean.qo.PartyBranchQO;
import com.ssit.stage.biz.bean.qo.PartyMemberQO;
import com.ssit.stage.biz.bean.qo.StageQO;
import com.ssit.stage.biz.bean.vo.*;
import com.ssit.stage.biz.dao.StageManageMapper;
import com.ssit.stage.biz.dao.StageMapper;
import com.ssit.stage.biz.service.StageManageService;
import com.ssit.stage.common.constant.ConstantKey;
import com.ssit.stage.common.exception.BaseException;
import com.ssit.stage.common.exception.subtype.DatabaseException;
import com.ssit.stage.common.exception.subtype.ParamInvalidException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务处理类
 *
 * @author Fs
 * @since 2017/4/5 21:25
 */
@Service("stageEditService")
@Transactional
public class StageManageServiceImpl implements StageManageService {
    private static final Log LOGGER = LogFactory.getLog(StageManageServiceImpl.class);

    private final StageManageMapper stageManageMapper;

    private final StageMapper stageMapper;

    @Autowired
    public StageManageServiceImpl(StageManageMapper stageManageMapper, StageMapper stageMapper) {
        this.stageManageMapper = stageManageMapper;
        this.stageMapper = stageMapper;
    }

    @Override
    public void createStage(StagePO stage) {
        if (stage == null || stage.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("stage", JSONObject.toJSONString(stage)));
            throw exception;
        }
        int count = stageManageMapper.createStage(stage);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public void modifyStage(StagePO stage) {
        if (stage == null || stage.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("stage", JSONObject.toJSONString(stage)));
            throw exception;
        }
        int count = stageManageMapper.updateStage(stage);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public Map<String, Object> queryStages(StageQO stage) {
        Map<String, Object> rlt = new HashMap<>();
        List<StageVO> rows = stageManageMapper.retrieveStages(stage);
        int total = stageManageMapper.retrieveStageCount(stage);
        rlt.put(ConstantKey.RESULT_ROWS, rows);
        rlt.put(ConstantKey.RESULT_TOTAL, total);
        return rlt;
    }

    @Override
    public void createPartyBranch(PartyBranchPO partyBranch) {
        if (partyBranch == null || partyBranch.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("partyBranch", JSONObject.toJSONString(partyBranch)));
            throw exception;
        }
        int count = stageManageMapper.createPartyBranch(partyBranch);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public void modifyPartyBranch(PartyBranchPO partyBranch) {
        if (partyBranch == null || partyBranch.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("partyBranch", JSONObject.toJSONString(partyBranch)));
            throw exception;
        }
        int count = stageManageMapper.updatePartyBranch(partyBranch);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public Map<String, Object> queryPartyBranches(PartyBranchQO partyBranch) {
        Map<String, Object> rlt = new HashMap<>();
        List<PartyBranchVO> rows = stageManageMapper.retrievePartyBranches(partyBranch);
        int total = stageManageMapper.retrievePartyBranchCount(partyBranch);
        rlt.put(ConstantKey.RESULT_ROWS, rows);
        rlt.put(ConstantKey.RESULT_TOTAL, total);
        return rlt;
    }

    @Override
    public void createPartyMember(PartyMemberPO partyMember) {
        if (partyMember == null || partyMember.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("partyMember", JSONObject.toJSONString(partyMember)));
            throw exception;
        }
        int count = stageManageMapper.createPartyMember(partyMember);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public void modifyPartyMember(PartyMemberPO partyMember) {
        if (partyMember == null || partyMember.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("partyMember", JSONObject.toJSONString(partyMember)));
            throw exception;
        }
        int count = stageManageMapper.updatePartyMember(partyMember);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public Map<String, Object> queryPartyMembers(PartyMemberQO partyMember) {
        Map<String, Object> rlt = new HashMap<>();
        List<PartyMemberVO> rows = stageManageMapper.retrievePartyMembers(partyMember);
        int total = stageManageMapper.retrievePartyMemberCount(partyMember);
        rlt.put(ConstantKey.RESULT_ROWS, rows);
        rlt.put(ConstantKey.RESULT_TOTAL, total);
        return rlt;
    }

    @Override
    public int queryPMCount(Integer partyBranchId) {
        if (partyBranchId == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("partyBranchId", "null"));
            throw exception;
        }
        PartyMemberQO partyMember = new PartyMemberQO();
        partyMember.setPartyBranchId(partyBranchId);
        return stageManageMapper.retrievePartyMemberCount(partyMember);
    }

    @Override
    public void createActivity(ActivityPO activity) {
        if (activity == null || activity.getId() == null || StringUtils.isBlank(activity.getTypeCode())) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("activity", JSONObject.toJSONString(activity)));
            throw exception;
        }

        // 保存活动信息
        int count = stageManageMapper.createActivity(activity);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }

        // 保存参与活动的党员信息
        Integer activityId = activity.getId();
        List<Integer> memberIdList = activity.getMemberIdList();
        if (memberIdList != null && !memberIdList.isEmpty()) {
            int size = memberIdList.size();
            List<MARelationPO> maRelationList = new ArrayList<>(size);
            MARelationPO maRelation;
            for (Integer memberId : memberIdList) {
                maRelation = new MARelationPO();
                maRelation.setPartyMemberId(memberId);
                maRelation.setActivityId(activityId);
                maRelationList.add(maRelation);
            }

            count = stageManageMapper.createMARelationBatch(maRelationList);
            if (count <= 0) {
                BaseException exception = new DatabaseException();
                LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                throw exception;
            }
        }
    }

    @Override
    public void modifyActivity(ActivityPO activity) {
        if (activity == null || activity.getId() == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("activity", JSONObject.toJSONString(activity)));
            throw exception;
        }
        int count = stageManageMapper.updateActivity(activity);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
    }

    @Override
    public Map<String, Object> queryActivities(ActivityQO activity) {
        Map<String, Object> rlt = new HashMap<>();
        List<ActivityVO> rows = stageManageMapper.retrieveActivities(activity);
        int total = stageManageMapper.retrieveActivityCount(activity);
        rlt.put(ConstantKey.RESULT_ROWS, rows);
        rlt.put(ConstantKey.RESULT_TOTAL, total);
        return rlt;
    }

    @Override
    public void examineActivity() {

    }

    @Override
    public List<DictionaryVO> queryOptions(String categoryCode) {
        return stageManageMapper.retrieveOptions(categoryCode);
    }

    @Override
    public List<BuildingVO> queryBuildingOptions() {
        return stageManageMapper.retrieveBuildingOptions();
    }

    @Override
    public List<PartyBranchVO> queryPartyBranchOptions() {
        return stageManageMapper.retrievePartyBranchOptions();
    }

    @Override
    public List<PartyMemberVO> queryPartyMemberOptions() {
        return stageManageMapper.retrievePartyMemberOptions();
    }
}