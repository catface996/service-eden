package com.catface.eden.http.util;

import com.catface.eden.BaseTest;
import com.catface.eden.http.config.propertis.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author catface
 * @since 2022/8/13
 */
@Slf4j
public class JwtUtilTest extends BaseTest {

    @Autowired
    private JwtProperties jwtProperties;

    @Test
    public void encode() {
        Map<String, String> claims = new HashMap<>();
        claims.put("ctxUserId", "123");
        claims.put("ctxClientId", "987");
        String jwtToken = JwtUtil.createJwtToken(claims, jwtProperties);
        log.info("jwtToken={}", jwtToken);
    }

    @Test
    public void decode() {
        String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJDbGllbnQiLCJjdHhDbGllbnRJZCI6Ijk4NyIsImN0eFVzZXJJZCI6IjEyMyIsImlzcyI6ImNhdGZhY2UiLCJleHAiOjE2NjA0Mjk2MTUsImlhdCI6MTY2MDM4NjQxNX0.jl_R-Ew2Ij4LzAFsujdS8zybxwRqwL-vvypHlb-yZQU";
        Map<String, String> claims = JwtUtil.verifyJwtToken(jwtToken, jwtProperties);
        log.info("claims={}", claims);
    }

    @Test
    public void encode_decode() {
        Map<String, String> claims = new HashMap<>();
        claims.put("ctxUserId", "123");
        claims.put("ctxClientId", "987");
        String jwtToken = JwtUtil.createJwtToken(claims, jwtProperties);
        log.info("jwtToken={}", jwtToken);

        Map<String, String> result = JwtUtil.verifyJwtToken(jwtToken, jwtProperties);
        log.info("claims={}", result);
    }
}
