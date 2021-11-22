package com.exa.account.service.impl;

import com.exa.common.ObjectResponse;
import com.exa.entity.Account;
import com.exa.mapper.AccountMapper;
import com.exa.account.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exa.request.RegisterReq;
import com.exa.response.RegisterResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo
 * @since 2021-09-14
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public ObjectResponse register(RegisterReq registerReq) {
        RegisterResp registerResp = RegisterResp.builder().build();
        BeanUtils.copyProperties(registerReq, registerResp);
        return ObjectResponse.generateResponse(registerResp);
    }
}
