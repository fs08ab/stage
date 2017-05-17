package com.ssit.stage.biz.dao;


import com.ssit.stage.biz.bean.po.*;
import com.ssit.stage.biz.bean.qo.ActivityQO;
import com.ssit.stage.biz.bean.qo.PartyBranchQO;
import com.ssit.stage.biz.bean.qo.PartyMemberQO;
import com.ssit.stage.biz.bean.qo.StageQO;
import com.ssit.stage.biz.bean.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 数据库操作：C/R/U/D
 */
@Repository
public interface StageManageMapper {

    int createStage(StagePO stage);

    int updateStage(StagePO stage);

    List<StageVO> retrieveStages(StageQO stage);

    int retrieveStageCount(StageQO stage);

    int createPartyBranch(PartyBranchPO partyBranch);

    int updatePartyBranch(PartyBranchPO partyBranch);

    int updatePartyBranchAddScore(@Param("partyMemberId") int partyBranchId, @Param("score") int score);

    List<PartyBranchVO> retrievePartyBranches(PartyBranchQO partyBranch);

    int retrievePartyBranchCount(PartyBranchQO partyBranch);

    int createPartyMember(PartyMemberPO partyMember);

    int updatePartyMember(PartyMemberPO partyMember);

    int updatePartyMemberAddScore(@Param("partyMemberId") int partyMemberId, @Param("score") int score);

    List<PartyMemberVO> retrievePartyMembers(PartyMemberQO partyMember);

    int retrievePartyMemberCount(PartyMemberQO partyMember);

    int createActivity(ActivityPO activity);

    int updateActivity(ActivityPO activity);

    List<ActivityVO> retrieveActivities(ActivityQO activity);

    int retrieveActivityCount(ActivityQO activity);

    // void examineActivity();

    // int createMARelationBatch(List<MARelationPO> maRelationList);

    int createMARelationBatch(@Param("activityId") Integer activityId, @Param("partyMemberIds") List<Integer> partyMemberIds);

    int updatePMAScore(MARelationPO maRelation);

    int deleteMARelationBatch(List<MARelationPO> maRelationList);

    List<DictionaryVO> retrieveOptions(String categoryCode);

    List<BuildingVO> retrieveBuildingOptions();

    List<PartyBranchVO> retrievePartyBranchOptions();

    List<PartyMemberVO> retrievePartyMemberOptions();

    /**
     * 统计参加活动activityId的党员，各自参加typeCode类型的活动的次数
     */
    List<Map<String, Integer>> retrievePMATStatistic(@Param("activityId") Integer activityId, @Param("typeCode") String typeCode);
}
