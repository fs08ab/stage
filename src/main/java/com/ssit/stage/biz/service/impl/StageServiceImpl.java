package com.ssit.stage.biz.service.impl;

import com.ssit.stage.biz.bean.vo.*;
import com.ssit.stage.biz.dao.StageMapper;
import com.ssit.stage.biz.service.StageService;
import com.ssit.stage.common.constant.ConstantKey;
import com.ssit.stage.common.utils.DateTimeUtils;
import com.ssit.stage.common.utils.RegionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 业务处理类
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
@Service("stageService")
@Transactional
public class StageServiceImpl implements StageService {
    private final StageMapper stageMapper;

    @Autowired
    public StageServiceImpl(StageMapper stageMapper) {
        this.stageMapper = stageMapper;
    }

    @Override
    public List<SectionVO> querySections() {
        return stageMapper.retrieveSections();
    }

    @Override
    public SectionVO querySectionById(int sectionId) {
        SectionVO sectionVO = stageMapper.retrieveSectionById(sectionId);
        if (sectionVO != null) {
            sectionVO.init();
        }
        return sectionVO;
    }

    @Override
    public BuildingVO queryBuildingById(String buildingId) {
        return stageMapper.retrieveBuildingById(buildingId);
    }

    @Override
    public List<PartyBranchVO> queryPartyBranches(String buildingId) {
        return stageMapper.retrievePartyBranches(buildingId,
                DateTimeUtils.getFirstDay(Calendar.YEAR), DateTimeUtils.getLastDay(Calendar.YEAR));
    }

    @Override
    public List<PartyMemberVO> queryPartyMembers(int partyBranchId) {
        return stageMapper.retrievePartyMembers(partyBranchId,
                DateTimeUtils.getFirstDay(Calendar.YEAR), DateTimeUtils.getLastDay(Calendar.YEAR));
    }

    @Override
    public MemberStatisticVO queryMemberStatistic(String buildingId) {
        MemberStatisticVO memberStatistic = stageMapper.retrieveMemberStatistic(buildingId);
        if (memberStatistic != null) {
            memberStatistic.packageData();
        }
        return memberStatistic;
    }

    @Override
    public List<ActivityVO> queryActivities(Integer type, int relationId) {
        return stageMapper.retrieveActivities(type, relationId,
                DateTimeUtils.getFirstDay(Calendar.YEAR), DateTimeUtils.getLastDay(Calendar.YEAR));
    }

    @Override
    public List<ActivityRuleVO> queryActivityRules() {
        Map<String, ActivityRuleVO> ruleMap = stageMapper.retrieveActivityRules();
        List<ActivityRuleVO> ruleList;
        if (ruleMap != null && !ruleMap.isEmpty()) {
            ruleList = new ArrayList<>();
            ruleList.addAll(ruleMap.values());
            return ruleList;
        }
        return null;
    }

    @Override
    public List<ActivityVO> queryActivitiesByPM(int partyMemberId) {
        return stageMapper.retrieveActivitiesByPM(partyMemberId,
                DateTimeUtils.getFirstDay(Calendar.YEAR), DateTimeUtils.getLastDay(Calendar.YEAR));
    }

    @Override
    public Map<String, Object> queryPMAStatistic(int partyMemberId) {
        List<Map<String, Object>> statistic = stageMapper.retrievePMAStatistic(partyMemberId,
                DateTimeUtils.getFirstDay(Calendar.YEAR), DateTimeUtils.getLastDay(Calendar.YEAR));
        if (statistic == null || statistic.isEmpty()) {
            return null;
        }

        Map<String, Object> rlt = new HashMap<>();
        float totalScore = 0;
        float itemScore;
        for (Map<String, Object> item : statistic) {
            itemScore = 0;
            Object typeCodeObj = item.get("type_code");
            if (typeCodeObj == null || "".equals(typeCodeObj)) {
                continue;
            }
            Object scoreObj = item.get(ConstantKey.BIZ_SCORE);
            if (scoreObj != null && !"".equals(scoreObj)) {
                itemScore = Float.valueOf(scoreObj.toString());
            }
            totalScore += itemScore;
        }

        List<DictionaryVO> memberLevel = stageMapper.retrieveDictionary(ConstantKey.BIZ_MEMBER_LEVEL);
        for (DictionaryVO dic : memberLevel) {
            String levelRegion = dic.getSupply();
            if (RegionUtils.getFloatRegion(levelRegion).isInclude(totalScore)) {
                rlt.put(ConstantKey.BIZ_MEMBER_LEVEL, dic.getItem());
                break;
            }
        }

        rlt.put(ConstantKey.BIZ_STATISTIC, statistic);
        rlt.put(ConstantKey.BIZ_TOTAL_SCORE, totalScore);
        return rlt;
    }
}