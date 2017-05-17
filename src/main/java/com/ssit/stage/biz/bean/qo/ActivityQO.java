package com.ssit.stage.biz.bean.qo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 建筑VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ActivityQO {
    private Integer id;
    private String name;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("type_code")
    private String typeCode;
    @JsonProperty("relation_id")
    private Integer relationId;
    private String status;

    private int offset;
    private Integer limit;
    @JsonProperty("sort_name")
    private String sortName;
    @JsonProperty("sort_order")
    private String sortOrder;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
