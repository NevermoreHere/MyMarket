package com.exa.account.proxy;

import com.exa.common.CommonConstant;

public class NetworkProxy implements INetwork{
    private INetwork network;

    public NetworkProxy(){
        network = new Network();
    }
    @Override
    public void get(String url) {
        if(CommonConstant.BLOCK_URL_LIST.contains(url)){

        }
    }
}
