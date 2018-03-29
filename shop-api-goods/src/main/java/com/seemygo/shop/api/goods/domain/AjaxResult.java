package com.seemygo.shop.api.goods.domain;

public class AjaxResult {
	private boolean success = true;
	private String msg;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private Object data;
	public AjaxResult() {}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg){
		this.success = false;
		this.msg = msg;
	}

}
