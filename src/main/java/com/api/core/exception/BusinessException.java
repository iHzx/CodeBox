package com.api.core.exception;

import com.api.core.constants.Constants;
import com.api.core.model.IResponseStatus;

import java.util.UUID;

/**
 * 业务异常类
 * @author huzhaoxi
 * @date 2019/09/27 09:20
 */
public class BusinessException extends Exception{

    // 异常代码
    private String code;

    // 异常信息
    private String message;

    // 异常id
    private String errorId;

    // 异常数据
    private Object errorData;

    private BusinessException(String code, String message, Object errorData) {
        super(message);
        this.code = code;
        this.message = message;
        this.errorId = UUID.randomUUID().toString();
        this.errorData = errorData;
    }

    public BusinessException(String message) {
        this(Constants.Response.FAILURE.getCode(), message, null);
    }

    public BusinessException(IResponseStatus status) {
        this(status, null);
    }

    public BusinessException(IResponseStatus status, Object errorData) {
        this(status.getCode(), status.getMessage(), errorData);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }
}