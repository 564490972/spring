package com.abead.utils;

/**
 * Created by czx on 2017/6/5.
 */
public enum ErrorCode {

    PARAM_ERROR("1001", "参数错误"), REQUEST_INVALID("1002", "请求失效"), REQUEST_TIMEOUT("1003",
            "请求超时"), NOT_FOUND_RESULT("2001", "找不到结果");

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
