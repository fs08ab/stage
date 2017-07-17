package com.ssit.stage.biz.service;


import com.ssit.stage.biz.bean.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 业务处理类
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
public interface StageService {
    List<SectionVO> querySections();

    SectionVO querySectionById(int sectionId);

    BuildingVO queryBuildingById(String buildingId);

    List<PartyBranchVO> queryPartyBranches(String buildingId);

    List<PartyMemberVO> queryPartyMembers(int partyBranchId);

    MemberStatisticVO queryMemberStatistic(String buildingId);

    List<ActivityVO> queryActivities(Integer type, int relationId);

    List<ActivityRuleVO> queryActivityRules();

    List<ActivityVO> queryActivitiesByPM(int partyMemberId);

    Map<String, Object> queryPMAStatistic(int partyMemberId);
}
