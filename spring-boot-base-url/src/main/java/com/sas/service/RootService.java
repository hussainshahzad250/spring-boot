package com.sas.service;

import javax.servlet.http.HttpServletRequest;

public interface RootService {

    String getClientIp(HttpServletRequest request);

    String getBaseUrl(HttpServletRequest request);

    String getLocalHostName();

    String getLocalHostIPAddress();
}
