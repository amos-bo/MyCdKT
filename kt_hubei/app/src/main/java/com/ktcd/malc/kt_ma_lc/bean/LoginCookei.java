package com.ktcd.malc.kt_ma_lc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public class LoginCookei implements Serializable{
    private List<String> username;
    public List<String> getUsername() {
        return username;
    }
    public void setUsername(List<String> username) {
        this.username = username;
    }
}
