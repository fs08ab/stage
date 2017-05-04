package com.ssit.stage.biz.bean.po;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.List;

/**
 * 建筑VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ActivityPO {
    private Integer id;
    private String name;
    private String date;
    private String note;
    private String image;
    private String typeCode;
    // @JsonProperty("relation_id")
    private Integer relationId;

    private List<Integer> memberIdList;

    public Integer getId() {
        return id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public List<Integer> getMemberIdList() {
        return memberIdList;
    }
}
