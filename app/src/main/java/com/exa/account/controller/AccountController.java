package com.exa.account.controller;


import com.exa.account.service.IAccountService;
import com.exa.common.ExportStatus;
import com.exa.common.ObjectResponse;
import com.exa.request.CeshiReq;
import com.exa.request.RegisterReq;
import com.exa.response.RegisterResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leo
 * @since 2021-09-14
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    IAccountService accountService;

    @PostMapping("/hello")
    @ResponseBody
    public ObjectResponse ceshi(@RequestBody CeshiReq exportStatus){
        System.out.println(exportStatus);
        return ObjectResponse.generateResponse(1);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResponse<RegisterResp> register(RegisterReq registerReq)
    {
        return accountService.register(registerReq);
    }



    /**
     * 用户登录
     * @param user POJO
     * @param returnUrl 返回跳转URL
     * @param response
     * @param request
     * @return
     */
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(TbUser user, String returnUrl, HttpServletResponse response, HttpServletRequest request) {
//
//        XbinResult result = userService.login(user);
//
//        if (result.getStatus() == 200) {
//
//            CookieUtils.setCookie(request, response, Const.TOKEN_LOGIN, result.getData().toString());
//            //有返回URL 跳转
//            if (StringUtils.isNotBlank(returnUrl)) {
//                return "({'success':'" + returnUrl + "'})";
//            }
//            return PORTAL_PATH;
//        }
//
//        if (result.getStatus() == 400) {
//
//            return USER_NOT_EXIST;
//        }
//
//        if (result.getStatus() == 401) {
//
//            return PASSWORD_ERROR;
//        }
//
//        return PASSWORD_ERROR;
//
//    }
}
