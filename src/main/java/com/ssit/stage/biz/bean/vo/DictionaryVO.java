package com.ssit.stage.biz.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 数据字典
 *
 * @author Fs
 * @since 2017/4/12 16:53
 */
public class DictionaryVO {
    @JSONField(name = "item_code")
    private String itemCode;
    private String item;
    @JSONField(name = "category_code")
    private String categoryCode;
    private String category;
    private String supply;

    public String getItemCode() {
        return itemCode;
    }

    public String getItem() {
        return item;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getCategory() {
        return category;
    }

    public String getSupply() {
        return supply;
    }
}
