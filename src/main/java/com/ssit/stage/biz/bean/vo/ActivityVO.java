package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    private int score;
    private String typeCode;
    private String type;

    @JSONField(name = "relation_id")
    private int relationId;

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

    public int getScore() {
        return score;
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
}
