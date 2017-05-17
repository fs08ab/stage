package com.ssit.stage.common.constant;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssit.stage.common.exception.BaseException;
import com.ssit.stage.common.exception.subtype.ParamInvalidException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一返回信息
 *
 * @author Fs
 * @since 2017/4/5 23:39
 */
public class StandardResult {

    private String resultCode;

    private String resultMessage;

    private Object attach;

    @JSONField(serialize = false)
    private Map<String, Object> mapAttach = new HashMap<>();

    @JSONField(serialize = false)
    private List<Object> listAttach = new ArrayList<>();

    public StandardResult(ResultType resultType) {
        if (resultType == null) {
            throw new ParamInvalidException();
        }
        this.resultCode = resultType.getResultCode();
        this.resultMessage = resultType.getResultMessage();
    }

    public StandardResult(BaseException e) {
        this.resultCode = ResultType.FAILED.getResultCode();
        this.resultMessage = ResultType.FAILED.getResultMessage();

        this.putAttach(ConstantKey.ERROR_CODE, e.getCode());
        this.putAttach(ConstantKey.ERROR_MESSAGE, e.getMessage());
    }

    public void putAttach(String key, Object value) {
        if (listAttach.isEmpty()) {
            this.mapAttach.put(StringUtils.trimToNull(key), value);
            this.attach = this.mapAttach;
        }
    }

    public void putAttachAll(Map<String, Object> attach) {
        if (listAttach.isEmpty()) {
            if (attach != null && !attach.isEmpty()) {
                this.mapAttach.putAll(attach);
            }
            this.attach = this.mapAttach;
        }
    }

    public void addAttach(Object value) {
        if (mapAttach.isEmpty()) {
            this.listAttach.add(value);
            this.attach = this.listAttach;
        }
    }

    public void addAttachAll(List<Object> attach) {
        if (mapAttach.isEmpty()) {
            if (attach != null && !attach.isEmpty()) {
                this.listAttach.addAll(attach);
            }
            this.attach = this.listAttach;
        }
    }

    public void setAttach(Object attach) {
        this.attach = attach;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public Object getAttach() {
        return attach;
    }

    public enum ResultType {
        SUCCESS("S", "请求成功"),

        FAILED("F", "请求失败");

        private String resultCode;

        private String resultMessage;

        ResultType(String resultCode, String resultMessage) {
            this.resultCode = resultCode;
            this.resultMessage = resultMessage;
        }

//        public static ResultType getResultType(String resultCode) {
//            if (StringUtils.isBlank(resultCode)) {
//                return null;
//            }
//            for (ResultType temp : values()) {
//                if (StringUtils.equalsIgnoreCase(temp.getResultCode(), resultCode)) {
//                    return temp;
//                }
//            }
//            return null;
//        }

        public String getResultCode() {
            return resultCode;
        }

        public String getResultMessage() {
            return resultMessage;
        }
    }
}
