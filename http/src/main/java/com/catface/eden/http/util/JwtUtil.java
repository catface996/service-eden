package com.catface.eden.http.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.catface.common.exception.CatfaceException;
import com.catface.eden.common.enums.BizErrorEnum;
import com.catface.eden.http.config.propertis.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author catface
 * @since 2022/8/13
 */
@Slf4j
public class JwtUtil {

    /**
     * 生成 JWT Token
     *
     * @param claimMap      待加入到token中的参数
     * @param jwtProperties jwt秘钥相关
     * @return 加密后的token
     */
    public static String createJwtToken(Map<String, String> claimMap, JwtProperties jwtProperties) {

        Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecret());

        //jwt 头部信息
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // jwt 时间相关
        DateTime nowDate = DateTime.now();
        Date expireDate = nowDate.plusSeconds(jwtProperties.getExp()).toDate();

        JWTCreator.Builder builder = JWT.create()
                .withHeader(map)
                .withIssuer(jwtProperties.getIssuer())
                .withAudience("Client");
        claimMap.forEach(builder::withClaim);

        builder.withIssuedAt(nowDate.toDate())
                .withExpiresAt(expireDate);
        return builder.sign(algorithm);

    }


    /**
     * 验证 token
     *
     * @param token         待验证的token
     * @param jwtProperties jwt秘钥相关
     * @return claims 中的key,value
     */
    public static Map<String, String> verifyJwtToken(String token, JwtProperties jwtProperties) {
        Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecret());
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(jwtProperties.getIssuer())
                .build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        } catch (TokenExpiredException e) {
            throw new CatfaceException(BizErrorEnum.TOKEN_HAS_EXPIRED);
        }
        Map<String, Claim> claims = jwt.getClaims();
        Map<String, String> result = new HashMap<>();
        claims.forEach((k, v) -> {
            log.debug("claim key={},value={}", k, v);
            result.put(k, v.asString());
        });
        Date exp = claims.get("exp").asDate();
        Assert.state(DateTime.now().isBefore(exp.getTime()), "token已经过期");
        return result;
    }
}
