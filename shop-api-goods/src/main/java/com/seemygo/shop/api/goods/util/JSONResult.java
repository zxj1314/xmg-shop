package com.seemygo.shop.api.goods.util;

import java.io.Serializable;

/**
 * Created by zlb on 2017.10.10.
 */

public class JSONResult implements Serializable{
    private boolean success = true;
    private String msg;
    private Object obj;
    public JSONResult() {
        super();
    }

    public JSONResult(String msg) {
        super();
        this.msg = msg;
    }

    public JSONResult(Boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setErrorMsg(String msg){
        this.msg = msg;
        this.success = false;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
