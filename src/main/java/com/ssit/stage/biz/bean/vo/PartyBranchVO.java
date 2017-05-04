package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 党支部VO
 *
 * @author Fs
 * @since 2017/3/6 19:13
 */
public class PartyBranchVO {
    private Integer id;
    private String name;
    @JSONField(name = "secretary_id")
    private Integer secretaryId;
    @JSONField(name = "sj_name")
    private String secretaryName;
    @JSONField(name = "superior_id")
    private Integer superiorId;
    @JSONField(name = "superior_name")
    private String superiorName;
    @JSONField(name = "level_code")
    private String levelCode;
    private String level;
    private int score;
    @JSONField(name = "next_level_code")
    private String nextLevelCode;
    @JSONField(name = "next_level")
    private String nextLevel;
    private String advance;
    @JSONField(name = "number")
    private Integer partyMemberCount;
    @JSONField(name = "activity_count")
    private Integer activityCount;

    @JSONField(name = "building_id")
    private String buildingId;
    @JSONField(name = "building_name")
    private String buildingName;
    private Integer floor;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSecretaryId() {
        return secretaryId;
    }

    public String getSecretaryName() {
        return secretaryName;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public String getSuperiorName() {
        return superiorName;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public String getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public String getNextLevelCode() {
        return nextLevelCode;
    }

    public String getNextLevel() {
        return nextLevel;
    }

    public String getAdvance() {
        return advance;
    }

    public Integer getPartyMemberCount() {
        return partyMemberCount;
    }

    public Integer getActivityCount() {
        return activityCount;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public Integer getFloor() {
        return floor;
    }
}
