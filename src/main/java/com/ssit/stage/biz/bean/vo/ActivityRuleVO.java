package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 活动规则VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
public class ActivityRuleVO {
    @JSONField(name = "activity_kind")
    private String activityKind;
    @JSONField(name = "type_code")
    private String typeCode;
    @JSONField(name = "activity_type")
    private String activityType;
    @JSONField(name = "member_spt")
    private float memberSPT;
    @JSONField(name = "member_tl")
    private Integer memberTL;
    @JSONField(name = "branch_spt")
    private float branchSPT;
    @JSONField(name = "branch_tl")
    private Integer branchTL;

    public String getActivityKind() {
        return activityKind;
    }

    public String getActivityType() {
        return activityType;
    }

    public float getMemberSPT() {
        return memberSPT;
    }

    public Integer getMemberTL() {
        return memberTL;
    }

    public float getBranchSPT() {
        return branchSPT;
    }

    public Integer getBranchTL() {
        return branchTL;
    }
}
