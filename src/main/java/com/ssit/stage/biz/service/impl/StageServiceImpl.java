package com.ssit.stage.biz.service.impl;

import com.ssit.stage.biz.bean.vo.*;
import com.ssit.stage.biz.dao.StageMapper;
import com.ssit.stage.biz.service.StageService;
import com.ssit.stage.common.constant.ConstantKey;
import com.ssit.stage.common.utils.RegionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


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
        return stageMapper.retrievePartyBranches(buildingId, null, null);
    }

    @Override
    public List<PartyMemberVO> queryPartyMembers(int partyBranchId) {
        return stageMapper.retrievePartyMembers(partyBranchId, null, null);
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
        return stageMapper.retrieveActivities(type, relationId, null, null);
    }

    @Override
    public List<ActivityVO> queryActivitiesByPM(int partyMemberId) {
        return stageMapper.retrieveActivitiesByPM(partyMemberId, null, null);
    }

    @Override
    public Map<String, Object> queryPMAStatistic(int partyMemberId) {
        List<Map<String, Object>> statistic = stageMapper.retrievePMAStatistic(partyMemberId, null, null);
        if (statistic == null || statistic.isEmpty()) {
            return null;
        }

        Map<String, Object> rlt = new HashMap<>();
        int totalScore = 0;

        int shykScore = 0;
        int itemScore = 0;
        Iterator<Map<String, Object>> iterator = statistic.iterator();
        while (iterator.hasNext()) {
            itemScore = 0;
            Map<String, Object> item = iterator.next();
            Object typeCodeObj = item.get("type_code");
            if (typeCodeObj == null || "".equals(typeCodeObj)) {
                continue;
            }
            Object scoreObj = item.get(ConstantKey.BIZ_SCORE);
            if (scoreObj != null && !"".equals(scoreObj)) {
                itemScore = Integer.valueOf(scoreObj.toString());
            }
            totalScore += itemScore;
            if (StringUtils.equalsAnyIgnoreCase(String.valueOf(typeCodeObj), "1", "2", "3", "4")) {
                iterator.remove();
                shykScore += itemScore;
            }
        }
        Map<String, Object> shykMap = new HashMap<>();
        shykMap.put(ConstantKey.BIZ_SCORE, shykScore);
        shykMap.put("type", "三会一课");
        shykMap.put("type_code", 11);
        statistic.add(shykMap);

        List<DictionaryVO> memberLevel = stageMapper.retrieveDictionary(ConstantKey.BIZ_MEMBER_LEVEL);
        for (DictionaryVO dic : memberLevel) {
            String levelRegion = dic.getSupply();
            if (RegionUtils.getIntegerRegion(levelRegion).isInclude(totalScore)) {
                rlt.put(ConstantKey.BIZ_MEMBER_LEVEL, dic.getItem());
                break;
            }
        }

        rlt.put(ConstantKey.BIZ_STATISTIC, statistic);
        rlt.put(ConstantKey.BIZ_TOTAL_SCORE, totalScore);
        return rlt;
    }
}