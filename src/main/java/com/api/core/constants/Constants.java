package com.api.core.constants;

import com.api.core.model.IResponseStatus;

/**
 * 系统级常量
 * @author huzhaoxi
 * @date 2019/09/27 09:20
 */
public interface Constants {

    /**
     * 系统级响应对象
     * @author huzhaoxi
     * @date 2019/09/27 09:20
     */
    enum Response implements IResponseStatus {
        SUCCESS("SUCCESS", "请求成功"),
        FAILURE("FAILURE", "请求失败"),
        DATA_EMPTY("DATA_EMPTY", "未找到目标资源"),
        BAD_REQUEST("BAD_REQUEST", "非法请求"),
        ;

        private String code;

        private String message;

        Response(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}