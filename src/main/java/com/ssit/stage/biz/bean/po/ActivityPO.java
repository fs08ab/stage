package com.ssit.stage.biz.bean.po;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("type_code")
    private String typeCode;
     @JsonProperty("relation_id")
    private Integer relationId;
    @JsonProperty("member_ids")
    private List<Integer> memberIds;
    /**
     * 保存党支部发起该活动可获得的分数
     */
    private Float score;
    private String status;

    public Integer getId() {
        return id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
