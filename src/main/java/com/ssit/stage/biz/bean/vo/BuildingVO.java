package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 建筑VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
public class BuildingVO{
    private String id;
    private String name;
    @JSONField(serialize = false)
    private int partyBranchCount;
    @JSONField(name = "dy_number")
    private Integer partyMemberCount;
    @JSONField(name = "floors_total")
    private Integer floorsTotal;
    private String offset;
    @JSONField(name = "stage")
    private StageVO stageVO;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPartyBranchCount() {
        return partyBranchCount;
    }

    public Integer getPartyMemberCount() {
        return partyMemberCount;
    }

    public Integer getFloorsTotal() {
        return floorsTotal;
    }

    public String getOffset() {
        return offset;
    }

    public StageVO getStageVO() {
        return stageVO;
    }
}
