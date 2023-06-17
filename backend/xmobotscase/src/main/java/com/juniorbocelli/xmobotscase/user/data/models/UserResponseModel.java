package com.juniorbocelli.xmobotscase.user.data.models;

public class UserResponseModel {
    private int code;
    private String message;

    public UserResponseModel() {

    }

    public UserResponseModel(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
