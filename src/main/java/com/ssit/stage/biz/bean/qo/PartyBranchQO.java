package com.ssit.stage.biz.bean.qo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 党支部VO
 *
 * @author Fs
 * @since 2017/3/6 19:13
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PartyBranchQO {
    private String name;
    @JsonProperty("secretary_id")
    private Integer secretaryId;
    @JsonProperty("sj_name")
    private String secretaryName;
    @JsonProperty("building_id")
    private String buildingId;
    private Integer floor;

    private int offset;
    private Integer limit;
    @JsonProperty("sort_name")
    private String sortName;
    @JsonProperty("sort_order")
    private String sortOrder;
}
