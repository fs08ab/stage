package com.ssit.stage.biz.bean.po;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 党支部VO
 *
 * @author Fs
 * @since 2017/3/6 19:13
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PartyBranchPO {
    private Integer id;
    private String name;
    @JsonProperty("secretary_id")
    private Integer secretaryId;
    @JsonProperty("superior_id")
    private Integer superiorId;
    @JsonProperty("number")
    private Integer partyMemberCount;
    @JsonProperty("building_id")
    private String buildingId;
    private Integer floor;

    public Integer getId() {
        return id;
    }
}
