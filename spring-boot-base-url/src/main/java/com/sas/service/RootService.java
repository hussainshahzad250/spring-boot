package com.sas.service;

import javax.servlet.http.HttpServletRequest;

public interface RootService {

    String getClientIp(HttpServletRequest request);

    public String getBaseUrl(HttpServletRequest request);
}
