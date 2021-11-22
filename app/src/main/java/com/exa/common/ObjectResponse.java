package com.exa.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对象类响应
 */
@ApiModel(value = "对象响应")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResponse<T> {

    @ApiModelProperty(value = "返回码", example = "0")
    @JsonProperty("code")
    @Builder.Default
    private ResponseCode code = ResponseConstant.DEFAULT_RESPONSE_CODE;

    @ApiModelProperty(value = "错误信息", example = "SUCCESS")
    @JsonProperty("msg")
    @Builder.Default
    private String msg = ResponseConstant.DEFAULT_SUCCESS_MESSAGE;

    @ApiModelProperty(value = "对象数据")
    @JsonProperty("data")
    T data;

    public static <T> ObjectResponse<T> generateResponse(T item) {
        ObjectResponse<T> response = new ObjectResponse<>();
        response.setData(item);
        return response;
    }

    public boolean isSuccess(){
        return ResponseCode.CODE_SUCCESS.equals(code);
    }

}



