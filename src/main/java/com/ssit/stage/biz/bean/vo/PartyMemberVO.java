package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 党员VO
 *
 * @author Fs
 * @since 2017/3/6 19:16
 */
public class PartyMemberVO {
    private Integer id;
    private String name;
    @JSONField(name = "sex_code")
    private String sexCode;
    private String sex;
    @JSONField(name = "birthday")
    private String birthDate;
    @JSONField(name = "education_code")
    private String educationCode;
    private String education;
    @JSONField(name = "xzzw")
    private String admPost;
    @JSONField(name = "party_post_code")
    private String partyPostCode;
    @JSONField(name = "dnzw")
    private String partyPost;
    private Float score;

    @JSONField(name = "party_branch_id")
    private Integer partyBranchId;
    @JSONField(name = "party_branch_name")
    private String partyBranchName;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSexCode() {
        return sexCode;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public String getEducation() {
        return education;
    }

    public String getAdmPost() {
        return admPost;
    }

    public String getPartyPostCode() {
        return partyPostCode;
    }

    public String getPartyPost() {
        return partyPost;
    }

    public Float getScore() {
        return score;
    }

    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    public String getPartyBranchName() {
        return partyBranchName;
    }
}
