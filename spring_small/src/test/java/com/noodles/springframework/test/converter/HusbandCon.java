package com.noodles.springframework.test.converter;

import java.time.LocalDate;

/**
 * @description: HusbandCon
 * @author: liuxian
 * @date: 2022-11-14 23:03
 */
public class HusbandCon {

    private String wifeName;

    private LocalDate marriageDate;

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "wifeName='" + wifeName + '\'' +
                ", marriageDate=" + marriageDate +
                '}';
    }
}
