package com.ssit.stage.biz.bean.po;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StagePO {
    private Integer id;
    private String name;
    private String summary;
    private String image;
    @JsonProperty("party_branch_prefix")
    private String partyBranchPrefix;
    @JsonProperty("building_id")
    private String buildingId;
    private Integer floor;

    public Integer getId() {
        return id;
    }
}
