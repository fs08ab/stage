package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 片区VO
 *
 * @author Fs
 * @since 2017/3/6 18:56
 */
public class SectionVO {
    private Integer id;
    private String name;
    @JSONField(name = "sj_id")
    private Integer secretaryId;
    @JSONField(name = "sj_name")
    private String secretary;
    @JSONField(name = "qy_number")
    private Integer enterpriseCount;
    @JSONField(name = "ld_number")
    private Integer buildingCount;
    @JSONField(name = "dzb_number")
    private Integer partyBranchCount;
    @JSONField(name = "dy_number")
    private Integer partyMemberCount;
    private String camera;
    private String mesh;
    private List<BuildingVO> buildings;

    public void init() {
        if (buildings != null && !buildings.isEmpty()) {
            buildingCount = 0;
            partyBranchCount = 0;
            partyMemberCount = 0;
            for (BuildingVO building : buildings) {
                if (building.getId() != null) {
                    buildingCount++;
                }
                partyBranchCount += building.getPartyBranchCount();
                Integer buildingMemberCount = building.getPartyMemberCount() == null ? 0 : building.getPartyMemberCount();
                this.partyMemberCount += buildingMemberCount;
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSecretaryId() {
        return secretaryId;
    }

    public String getSecretary() {
        return secretary;
    }

    public Integer getEnterpriseCount() {
        return enterpriseCount;
    }

    public Integer getBuildingCount() {
        return buildingCount;
    }

    public Integer getPartyBranchCount() {
        return partyBranchCount;
    }

    public Integer getPartyMemberCount() {
        return partyMemberCount;
    }

    public String getCamera() {
        return camera;
    }

    public String getMesh() {
        return mesh;
    }

    public List<BuildingVO> getBuildings() {
        return buildings;
    }
}
