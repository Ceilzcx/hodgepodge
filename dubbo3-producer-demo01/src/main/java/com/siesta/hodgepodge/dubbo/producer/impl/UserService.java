package com.siesta.hodgepodge.dubbo.producer.impl;

import com.siesta.hodgepodge.dubbo.service.IUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(version = "1.0.0")
@Service
public class UserService implements IUserService {

    @Override
    public String sayHello() {
        return "producer call: hello world";
    }

}
