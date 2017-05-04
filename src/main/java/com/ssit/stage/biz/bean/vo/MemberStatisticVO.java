package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * 党员VO
 *
 * @author Fs
 * @since 2017/3/6 19:16
 */
public class MemberStatisticVO {
    @JSONField(serialize = false)
    private float femaleRate;
    @JSONField(serialize = false)
    private float maleRate;
    @JSONField(serialize = false)
    private float aft60Rate;
    @JSONField(serialize = false)
    private float aft70Rate;
    @JSONField(serialize = false)
    private float aft80Rate;
    @JSONField(serialize = false)
    private float aft90Rate;
    @JSONField(serialize = false)
    private float leCollegeRate;
    @JSONField(serialize = false)
    private float bachelorRate;
    @JSONField(serialize = false)
    private float masterRate;
    @JSONField(serialize = false)
    private float doctorRate;

    @JSONField(name = "sex")
    private List<Float> sexRate = new ArrayList<>();
    @JSONField(name = "education")
    private List<Float> eduRate = new ArrayList<>();
    @JSONField(name = "year")
    private List<Float> ageRate = new ArrayList<>();

    public void packageData() {
        sexRate.add(maleRate);
        sexRate.add(femaleRate);
        eduRate.add(leCollegeRate);
        eduRate.add(bachelorRate);
        eduRate.add(masterRate);
        eduRate.add(doctorRate);
        ageRate.add(aft60Rate);
        ageRate.add(aft70Rate);
        ageRate.add(aft80Rate);
        ageRate.add(aft90Rate);
    }

    public List<Float> getSexRate() {
        return sexRate;
    }

    public List<Float> getEduRate() {
        return eduRate;
    }

    public List<Float> getAgeRate() {
        return ageRate;
    }
}
