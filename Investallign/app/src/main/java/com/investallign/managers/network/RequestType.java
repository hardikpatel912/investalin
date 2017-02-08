package com.investallign.managers.network;

public enum RequestType {
    GET_PAGE("0.1/get-page"), GET_FAQ("0.1/get-faqs"), GET_STATISTICS("0.1/get-statistics");

    private final String methodName;

    RequestType(String methodName) {
        this.methodName = methodName;
    }


    public String getMethodName() {
        return methodName;
    }

}
