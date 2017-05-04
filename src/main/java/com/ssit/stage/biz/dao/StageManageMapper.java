package com.ssit.stage.biz.dao;


import com.ssit.stage.biz.bean.po.*;
import com.ssit.stage.biz.bean.qo.ActivityQO;
import com.ssit.stage.biz.bean.qo.PartyBranchQO;
import com.ssit.stage.biz.bean.qo.PartyMemberQO;
import com.ssit.stage.biz.bean.qo.StageQO;
import com.ssit.stage.biz.bean.vo.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<PartyBranchVO> retrievePartyBranches(PartyBranchQO partyBranch);

    int retrievePartyBranchCount(PartyBranchQO partyBranch);

    int createPartyMember(PartyMemberPO partyMember);

    int updatePartyMember(PartyMemberPO partyMember);

    List<PartyMemberVO> retrievePartyMembers(PartyMemberQO partyMember);

    int retrievePartyMemberCount(PartyMemberQO partyMember);

    int createActivity(ActivityPO activity);

    int updateActivity(ActivityPO activity);

    List<ActivityVO> retrieveActivities(ActivityQO activity);

    int retrieveActivityCount(ActivityQO activity);

    void examineActivity();

    int createMARelationBatch(List<MARelationPO> maRelationList);

    int deleteMARelationBatch(List<MARelationPO> maRelationList);

    List<DictionaryVO> retrieveOptions(String categoryCode);

    List<BuildingVO> retrieveBuildingOptions();

    List<PartyBranchVO> retrievePartyBranchOptions();

    List<PartyMemberVO> retrievePartyMemberOptions();
}
