package com.catface.eden.http.config.propertis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author catface
 * @since 2022/8/13
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secret;

    private String issuer;

    private Integer exp;

    public String getSecret() {
        return secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public Integer getExp() {
        return exp;
    }
}
