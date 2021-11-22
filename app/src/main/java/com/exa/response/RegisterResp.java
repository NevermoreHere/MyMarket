package com.exa.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "项目列表响应")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResp {
    @ApiModelProperty(value = "用户名", example = "xxxx")
    private String username;

    @ApiModelProperty(value = "手机号", example = "13616161616161")
    private String phone;

    @ApiModelProperty(value = "昵称", example = "haha")
    private String nickname;
}
