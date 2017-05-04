package com.ssit.stage.biz.bean.po;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 党员VO
 *
 * @author Fs
 * @since 2017/3/6 19:16
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PartyMemberPO {
    private Integer id;
    private String name;
    @JsonProperty("sex_code")
    private String sexCode;
    @JsonProperty("birthday")
    private String birthDate;
    @JsonProperty("education_code")
    private String educationCode;
    @JsonProperty("xzzw")
    private String admPost;
    @JsonProperty("party_post_code")
    private String partyPostCode;
    @JsonProperty("party_branch_id")
    private Integer partyBranchId;

    public Integer getId() {
        return id;
    }
}
