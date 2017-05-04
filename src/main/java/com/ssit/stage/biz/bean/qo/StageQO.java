package com.ssit.stage.biz.bean.qo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StageQO {
    private String name;
    private Integer floor;
    @JsonProperty("building_id")
    private String buildingId;

    private int offset;
    private Integer limit;
    @JsonProperty("sort_name")
    private String sortName;
    @JsonProperty("sort_order")
    private String sortOrder;
}
