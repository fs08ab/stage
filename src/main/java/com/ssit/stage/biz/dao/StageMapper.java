package com.ssit.stage.biz.dao;


import com.ssit.stage.biz.bean.vo.*;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 数据库操作：C/R/U/D
 */
@Repository
public interface StageMapper {

    List<SectionVO> retrieveSections();

    SectionVO retrieveSectionById(@Param("sectionId") int sectionId);

    BuildingVO retrieveBuildingById(@Param("buildingId") String buildingId);

    /**
     * 查询楼宇下的党支部列表，包含各党支部活动积分统计；时间区间表示其活动积分的统计范围，若起止时间均为空，则是对各党员所参与的所有活动进行积分统计
     *
     * @param buildingId 楼宇ID
     * @param startDate  党支部活动积分统计起始时间
     * @param endDate    党支部活动积分统计截至时间
     * @return 楼宇下党支部列表
     */
    List<PartyBranchVO> retrievePartyBranches(@Param("buildingId") String buildingId,
                                              @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 查询党支部下的党员列表，包含各党员活动积分统计；时间区间表示其活动积分的统计范围，若起止时间均为空，则是对各党员所参与的所有活动进行积分统计
     *
     * @param partyBranchId 党支部ID
     * @param startDate     党员活动积分统计起始时间
     * @param endDate       党员活动积分统计截至时间
     * @return 党支部下党员列表
     */
    List<PartyMemberVO> retrievePartyMembers(@Param("partyBranchId") int partyBranchId,
                                             @Param("startDate") String startDate, @Param("endDate") String endDate);

    MemberStatisticVO retrieveMemberStatistic(@Param("buildingId") String buildingId);

    /**
     * 查询时间区间范围内，驿站或党支部下的活动；若时间起止均为空，则是对其下所有活动进行统计
     *
     * @param typeCode   0：驿站 1：党支部
     * @param relationId 驿站或党支部ID，与typeCode搭配
     * @param startDate  被统计活动的起始时间，可为空
     * @param endDate    被统计活动的截至时间，可为空
     * @return 活动列表
     */
    List<ActivityVO> retrieveActivities(@Param("typeCode") Integer typeCode, @Param("relationId") int relationId,
                                        @Param("startDate") String startDate, @Param("endDate") String endDate);

    @MapKey("typeCode")
    Map<String, ActivityRuleVO> retrieveActivityRules();

    /**
     * 查询时间区间范围内，党员参与的活动；若时间起止均为空，则是对其参与的所有活动进行统计 TODO:
     *
     * @param partyMemberId 党员ID
     * @param startDate     被统计活动的起始时间，可为空
     * @param endDate       被统计活动的截至时间，可为空
     * @return 指定时间范围内，党员参与的活动
     */
    List<ActivityVO> retrieveActivitiesByPM(@Param("partyMemberId") int partyMemberId,
                                            @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 对时间区间范围内，党员参与活动的统计；若时间起止均为空，则是对所有参与活动的统计
     */
    List<Map<String, Object>> retrievePMAStatistic(@Param("partyMemberId") int partyMemberId,
                                                   @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<DictionaryVO> retrieveDictionary(@Param("categoryCode") String categoryCode);
}
