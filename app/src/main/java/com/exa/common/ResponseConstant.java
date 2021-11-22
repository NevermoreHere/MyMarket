package com.exa.common;

public class ResponseConstant {

    public static final ResponseCode DEFAULT_RESPONSE_CODE = ResponseCode.CODE_SUCCESS;

    public static final ResponseCode DEFAULT_ERROR_CODE = ResponseCode.CODE_SYSTEM_ERROR;

    public static final String DEFAULT_SUCCESS_MESSAGE = ResponseCode.CODE_SUCCESS.getDefaultMessage();

    public static final String DEFAULT_ERROR_MESSAGE = ResponseCode.CODE_SYSTEM_ERROR.getDefaultMessage();
}

