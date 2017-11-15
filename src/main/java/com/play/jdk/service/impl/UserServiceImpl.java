package com.play.jdk.service.impl;

import com.play.jdk.service.UserService;

/**
 * Created by fuzh2 on 2017/10/31.
 */
public class UserServiceImpl implements UserService {
    public void sayHello() {
        System.out.println("Hello Spring !" + getClass().getSimpleName());
    }
}
