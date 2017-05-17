package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 活动VO
 *
 * @author Fs
 * @since 2017/3/6 19:11
 */
public class ActivityVO {
    private Integer id;
    private String name;
    private Date date;
    private String note;
    private String image;
    @JSONField(name = "type_code")
    private String typeCode;
    private String type;
    @JSONField(name = "relation_id")
    private int relationId;
    @JSONField(name = "party_members")
    private List<PartyMemberVO> partyMembers;
    /**
     * 保存党支部发起该活动可获得的分数
     */
    private int score;
    private String status;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            return dateFormat.format(date);
        }
        return null;
    }

    public String getNote() {
        return note;
    }

    public String getImage() {
        return image;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getType() {
        return type;
    }

    public int getRelationId() {
        return relationId;
    }

    public List<PartyMemberVO> getPartyMembers() {
        return partyMembers;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }
}
