package com.exa.account.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {
}


@Slf4j
class NetworkMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("Cglib 代理");
        return methodProxy.invokeSuper(o, objects);
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Network.class);
        enhancer.setCallback(new NetworkMethodInterceptor());

        Network network = (Network) enhancer.create();
        network.get("123");
    }
}