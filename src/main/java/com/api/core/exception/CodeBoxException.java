package com.api.core.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CodeBoxException extends RuntimeException {

    /**
     * 用于处理异常信息
     */
    private static final long serialVersionUID = 1L;
    private String msg;

    public CodeBoxException(String msg) {
        this.msg = msg;
        log.error(msg);
    }

}
