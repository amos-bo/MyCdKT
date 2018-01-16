package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class SelectGrunpInfo implements Serializable {
    /**
     * 是否被选中
     */
    public boolean isSelected;
    /**
     * 组名
     */
    public String name;
    /**
     * 状态-在线人数
     */
    public String stateOnline;
    /**
     * 状态-总人数
     */
    public String stateAll;

    /**
     * 状态-组列表
     */
    public List<SelectPersonInfo> selectPersonInfoList;

}
