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
import com.ssit.stage.common.constant.ConstantValue;
import com.ssit.stage.common.exception.BaseException;
import com.ssit.stage.common.exception.BizException;
import com.ssit.stage.common.exception.SystemException;
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

        activity.setStatus(ConstantValue.ACTIVITY_STATUS[0]);
        // 保存活动信息
        int count = stageManageMapper.createActivity(activity);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }

        // 保存参与活动的党员信息
        Integer activityId = activity.getId();
        List<Integer> memberIdList = activity.getMemberIds();
        if (memberIdList != null && !memberIdList.isEmpty()) {
            count = stageManageMapper.createMARelationBatch(activityId, memberIdList);
            if (count <= 0) {
                BaseException exception = new DatabaseException();
                LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                throw exception;
            }
        }
    }

    @Override
    public void modifyActivity(ActivityPO activity) {
        Integer activityId;
        if (activity == null || (activityId = activity.getId()) == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("activity", JSONObject.toJSONString(activity)));
            throw exception;
        }
        // 修改之前，先查询数据库，校验原始数据
        ActivityQO activityQO = new ActivityQO();
        activityQO.setId(activityId);
        List<ActivityVO> dbActivityList = stageManageMapper.retrieveActivities(activityQO);
        if (dbActivityList == null || dbActivityList.isEmpty()) {
            BaseException exception = new SystemException();
            LOGGER.error(exception.getLogMessage("dbActivityList", JSONObject.toJSONString(dbActivityList)));
            throw exception;
        }
        ActivityVO dbActivity = dbActivityList.get(0);
        String dbStatus = dbActivity.getStatus();
        if (StringUtils.isNotBlank(dbStatus) && StringUtils.equals(dbStatus, ConstantValue.ACTIVITY_STATUS[1])) {
            BaseException exception = new BizException("活动已经被审核通过，不可再被修改");
            LOGGER.error(exception.getLogMessage());
            throw exception;
        }

        // 修改活动信息
        int count = stageManageMapper.updateActivity(activity);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }

        // 修改参加活动的党员信息
        List<MARelationPO> deleteList = new ArrayList<>();
        List<PartyMemberVO> dbMembers = dbActivity.getPartyMembers();
        List<Integer> paramMemberIds = activity.getMemberIds();
        dbMembers = dbMembers == null ? new ArrayList<>() : dbMembers;
        paramMemberIds = paramMemberIds == null ? new ArrayList<>() : paramMemberIds;
        MARelationPO maRelationPO;
        for (PartyMemberVO dbMemberVO : dbMembers) {
            if (paramMemberIds.contains(dbMemberVO.getId())) {
                // 从传入参数中去掉数据中已有的党员，剩下的即为待新插入数据库的党员列表
                paramMemberIds.remove(dbMemberVO.getId());
            } else {
                // 将数据库中存在，但传入参数中没有的党员放入deleteList中
                maRelationPO = new MARelationPO();
                maRelationPO.setPartyMemberId(dbMemberVO.getId());
                maRelationPO.setActivityId(activityId);
                deleteList.add(maRelationPO);
            }
        }

        if (!deleteList.isEmpty()) {
            count = stageManageMapper.deleteMARelationBatch(deleteList);
            LOGGER.debug(String.format("修改活动%s,剔除了%s个参与人", dbActivity.getName(), count));
        }
        if (!paramMemberIds.isEmpty()) {
            count = stageManageMapper.createMARelationBatch(activityId, paramMemberIds);
            LOGGER.debug(String.format("修改活动%s,新增了%s个参与人", dbActivity.getName(), count));
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
    public void examineActivity(ActivityPO activity) {
        Integer activityId;
        String status;
        String typeCode;
        Integer relationId;
        if (activity == null || (activityId = activity.getId()) == null || (typeCode = activity.getTypeCode()) == null
                || (relationId = activity.getRelationId()) == null || (status = activity.getStatus()) == null) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("activity", JSONObject.toJSONString(activity)));
            throw exception;
        }

        Integer branchScore = null;
        if (ConstantValue.ACTIVITY_STATUS[1].equals(status)) {
            // 审核通过的处理
            // 查询活动规则
            Map<String, ActivityRuleVO> rules = stageMapper.retrieveActivityRules();
            if (rules == null || rules.isEmpty()) {
                BaseException exception = new BizException("活动规则未设置");
                LOGGER.error(exception.getLogMessage());
                throw exception;
            }
            ActivityRuleVO activityRule = rules.get(typeCode);
            if (activityRule == null) {
                BaseException exception = new BizException("活动类型对应的规则未设置");
                LOGGER.error(exception.getLogMessage());
                throw exception;
            }

            /*
              计算党支部得分
              1.查询活动对应党支部，该类型活动参与次数
              2.根据活动规则，判断此次活动应得分数
              3.将分数更新至t_activity表
             */
            branchScore = activityRule.getBranchSPT();
            Integer branchTL = activityRule.getBranchTL();
            if (branchTL != null) {
                ActivityQO activityQO = new ActivityQO();
                activityQO.setStatus(ConstantValue.ACTIVITY_STATUS[1]);
                activityQO.setTypeCode(typeCode);
                activityQO.setRelationId(relationId);
                List<ActivityVO> branchActivities = stageManageMapper.retrieveActivities(activityQO);
                if (branchActivities != null && branchActivities.size() >= branchTL) {
                    branchScore = 0;
                }
            }

        /*
          计算党员得分
          1.查询参与本活动的党员与本类型活动参与次数的对应关系，放入map中
          2.根据活动规则，循环判断map中各党员在此次活动应得分数
          3.将得分更新进数据库
         */
            List<Map<String, Integer>> timeCountMap = stageManageMapper.retrievePMATStatistic(activityId, typeCode);
            if (timeCountMap != null && !timeCountMap.isEmpty()) {
                Integer memberTL = activityRule.getMemberTL();
                int defaultMemberScore = activityRule.getMemberSPT();
                int memberScore;
                MARelationPO maRelation;
                Integer partyMemberId;
                if (memberTL != null) {
                    Number timeCount;
                    for (Map<String, Integer> temp : timeCountMap) {
                        memberScore = defaultMemberScore;
                        timeCount = temp.get(ConstantKey.BIZ_COUNT);
                        if (memberTL.compareTo(timeCount.intValue()) <= 0) {
                            memberScore = 0;
                        }

                        maRelation = new MARelationPO();
                        partyMemberId = temp.get(ConstantKey.BIZ_MEMBER_ID);
                        maRelation.setPartyMemberId(partyMemberId);
                        maRelation.setActivityId(activityId);
                        maRelation.setScore(memberScore);
                        int count = stageManageMapper.updatePMAScore(maRelation);
                        if (count != 1) {
                            BaseException exception = new DatabaseException();
                            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                            throw exception;
                        }

                        if (memberScore != 0) {
                            count = stageManageMapper.updatePartyMemberAddScore(partyMemberId, memberScore);
                            if (count != 1) {
                                BaseException exception = new DatabaseException();
                                LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                                throw exception;
                            }
                        }
                    }
                } else {
                    for (Map<String, Integer> temp : timeCountMap) {
                        maRelation = new MARelationPO();
                        partyMemberId = temp.get(ConstantKey.BIZ_MEMBER_ID);
                        maRelation.setPartyMemberId(partyMemberId);
                        maRelation.setActivityId(activityId);
                        maRelation.setScore(defaultMemberScore);
                        int count = stageManageMapper.updatePMAScore(maRelation);
                        if (count != 1) {
                            BaseException exception = new DatabaseException();
                            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                            throw exception;
                        }
                        count = stageManageMapper.updatePartyMemberAddScore(partyMemberId, defaultMemberScore);
                        if (count != 1) {
                            BaseException exception = new DatabaseException();
                            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                            throw exception;
                        }
                    }
                }
            }
        } else if (!ConstantValue.ACTIVITY_STATUS[2].equals(status)) {
            BaseException exception = new ParamInvalidException();
            LOGGER.error(exception.getLogMessage("status", status));
            throw exception;
        }

        // 修改活动状态
        ActivityPO activityPO = new ActivityPO();
        activityPO.setId(activityId);
        activityPO.setStatus(status);
        activityPO.setScore(branchScore);
        int count = stageManageMapper.updateActivity(activityPO);
        if (count != 1) {
            BaseException exception = new DatabaseException();
            LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
            throw exception;
        }
        if (branchScore != null && branchScore != 0) {
            if (Integer.valueOf(typeCode) > 0) {
                count = stageManageMapper.updatePartyBranchAddScore(relationId, branchScore);
                if (count != 1) {
                    BaseException exception = new DatabaseException();
                    LOGGER.error(exception.getLogMessage("count", String.valueOf(count)));
                    throw exception;
                }
            }
        }
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