package com.example.bloodbank;

public class Member {
    private String name,bloodgrp,phone;

    public Member(String name, String bloodgrp, String phone) {
        this.name = name;
        this.bloodgrp = bloodgrp;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
