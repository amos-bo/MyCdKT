package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/15.
 */

public class MessageNumInfo implements Serializable {

    /**
     * msgType : actionPlanDirective
     * amount : 0
     */

    private String msgType;
    private int amount;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
