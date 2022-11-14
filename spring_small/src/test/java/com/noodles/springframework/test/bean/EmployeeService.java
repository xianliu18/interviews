package com.noodles.springframework.test.bean;

import com.noodles.springframework.stereotype.Component;
import java.util.Random;

/**
 * @description: EmployeeService
 * @author: liuxian
 * @date: 2022-11-14 08:55
 */
@Component("employeeService")
public class EmployeeService implements ICustomerService {

    private String token;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "王五, 20009, 广东";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success!";
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
