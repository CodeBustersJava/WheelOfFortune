package com.codebuster.enums;

public enum Money implements Possibilities {
    _100, _200, _300, _400, _500, _600, _1000, _1500;

    @Override
    public String toString() {
        String superString = super.toString();
        return superString.substring(1);
    }
}
