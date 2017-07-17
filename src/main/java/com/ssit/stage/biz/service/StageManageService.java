package com.ssit.stage.biz.service;


import com.ssit.stage.biz.bean.po.ActivityPO;
import com.ssit.stage.biz.bean.po.PartyBranchPO;
import com.ssit.stage.biz.bean.po.PartyMemberPO;
import com.ssit.stage.biz.bean.po.StagePO;
import com.ssit.stage.biz.bean.qo.ActivityQO;
import com.ssit.stage.biz.bean.qo.PartyBranchQO;
import com.ssit.stage.biz.bean.qo.PartyMemberQO;
import com.ssit.stage.biz.bean.qo.StageQO;

import java.util.List;
import java.util.Map;

/**
 * 业务处理类
 */
public interface StageManageService {

    void createStage(StagePO stage);

    void modifyStage(StagePO stage);

    Map<String, Object> queryStages(StageQO stage);

    void createPartyBranch(PartyBranchPO partyBranch);

    void modifyPartyBranch(PartyBranchPO partyBranch);

    Map<String, Object> queryPartyBranches(PartyBranchQO partyBranch);

    void createPartyMember(PartyMemberPO partyMember);

    void modifyPartyMember(PartyMemberPO partyMember);

    Map<String, Object> queryPartyMembers(PartyMemberQO partyMember);

    int queryPMCount(Integer partyBranchId);

    /**
     * 1、插入活动表，置状态为I（不计算党支部得分，审核时才确定得分）
     * 2、插入党员活动关系表（不计算党员得分，审核时才确定得分）
     */
    void createActivity(ActivityPO activity);

    /**
     * 1、判断状态是否为I，修改活动表
     * 2、插入或删除党员活动关系表
     */
    void modifyActivity(ActivityPO activity);

    Map<String, Object> queryActivities(ActivityQO activity);

    /**
     * <pre>
     * 审批活动
     * 通过： 1、修改活动表状态为S
     *       2、修改党员活动关系表分数（党员因本次活动获得的分数）（由于党员活动计分有次数限制，因此只能在审核时确定参与某次活动的得分）
     *       3、将本次得分加到党员总得分上
     *       4、修改活动表分数（党支部因本次活动获得的分数）（同上）
     *       5、将本次得分加到党支部总得分上
     * 拒绝： 1、修改活动表状态为F
     * </pre>
     */
    void examineActivity(ActivityPO activity);

    List<Map<String, String>> queryOptions(String categoryCode);

    List<Map<String, String>> queryBuildingOptions();

    List<Map<String, String>> queryStageOptions();

    List<Map<String, String>> queryPartyBranchOptions();

    List<Map<String, String>> queryPartyMemberOptions(String buildingId, Integer stageId, Integer partyBranchId);

    List<Map<String, String>> queryActivityTypeOptions();
}
