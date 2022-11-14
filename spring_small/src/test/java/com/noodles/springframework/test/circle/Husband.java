package com.noodles.springframework.test.circle;

/**
 * @description: Husband
 * @author: liuxian
 * @date: 2022-11-14 15:57
 */
public class Husband {

    private Wife wife;

    public String queryWife() {
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
