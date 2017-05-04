package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
public class StageVO {
    private Integer id;
    private String name;
    private String summary;
    private String image;
    @JSONField(name = "dzb_prefix")
    private String partyBranchPrefix;

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

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public String getPartyBranchPrefix() {
        return partyBranchPrefix;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }
}
