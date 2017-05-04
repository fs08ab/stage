package com.ssit.stage.biz.bean.qo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 党员VO
 *
 * @author Fs
 * @since 2017/3/6 19:16
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PartyMemberQO {
    private String name;
    @JsonProperty("sex_code")
    private String sexCode;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("education_code")
    private String educationCode;
    @JsonProperty("xzzw")
    private String admPost;
    @JsonProperty("party_post_code")
    private String partyPostCode;
    @JsonProperty("party_branch_id")
    private Integer partyBranchId;

    private int offset;
    private Integer limit;
    @JsonProperty("sort_name")
    private String sortName;
    @JsonProperty("sort_order")
    private String sortOrder;

    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }
}
