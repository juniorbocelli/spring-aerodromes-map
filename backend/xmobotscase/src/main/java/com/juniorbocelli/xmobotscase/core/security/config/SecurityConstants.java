package com.juniorbocelli.xmobotscase.core.security.config;

public class SecurityConstants {
    public static final String SECRET = "04b789983c8d33bcacadefdc9af77a287113a35ea5531a8610c3bf86e2665496";
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String LOGIN_URL = "/api/auth/login";
    public static final String SIGN_UP_URL = "api/user";
}
