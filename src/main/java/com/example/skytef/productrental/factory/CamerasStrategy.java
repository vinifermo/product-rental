package com.example.skytef.productrental.factory;

public class CamerasStrategy implements ProductStrategy {

    public static final double DEFAULT_USER_VALUE = 8.1;
    public static final long DEFAULT_PRODUCT_VALUE = 25L;

    @Override
    public Double userValue() {
        return DEFAULT_USER_VALUE;
    }

    @Override
    public Long productValue() {
        return DEFAULT_PRODUCT_VALUE;
    }
}
