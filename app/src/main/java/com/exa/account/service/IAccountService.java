package com.exa.account.service;

import com.exa.common.ObjectResponse;
import com.exa.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exa.request.RegisterReq;
import com.exa.response.RegisterResp;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo
 * @since 2021-09-14
 */
public interface IAccountService extends IService<Account> {
    ObjectResponse register(RegisterReq registerReq);
}
