package com.example.ERP_IT_Comany.security;

public class JwtProperties {
    public static final String SECRET = "NOTBASE64";
    public static final String SECRETTWOFISH = "my-secret-token-to-change-in-pro";
    public static final int EXPIRATION_TIME = 864_000_000; //10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
