package com.ssit.stage.biz.bean.po;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 建筑VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MARelationPO {
    private Integer partyMemberId;
    private Integer activityId;
    private Integer score;

    public void setPartyMemberId(Integer partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPartyMemberId() {
        return partyMemberId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public Integer getScore() {
        return score;
    }
}
