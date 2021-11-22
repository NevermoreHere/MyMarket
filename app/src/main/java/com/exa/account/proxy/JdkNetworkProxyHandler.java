package com.exa.account.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class JdkNetworkProxyHandler implements InvocationHandler {
    private INetwork iNetwork;

    JdkNetworkProxyHandler(INetwork network){
        this.iNetwork = network;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("before jdk 动态代理");
        log.info("invoke() 方法参数一："+proxy.getClass().getName());
        method.invoke(this.iNetwork, args);
        return proxy;
    }

    public static void main(String[] args) {
        INetwork network = new Network();
        InvocationHandler handler = new JdkNetworkProxyHandler(network);
        Class<? extends INetwork> clazz = network.getClass();
        INetwork proxy = (INetwork) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
        proxy.get("123");

    }
}


