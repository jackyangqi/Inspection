package com.yang.config.token;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yang.exception.CustomException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.codec.Base64;

@Component
public class TokenUtil {

	private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

	public static final String encryptJWTKey = "U0JBUElKV1RkV2FuZzkyNjQ1NA==";
	public static final String accessTokenExpireTime = "300";
	
	
	/**
     * 校验token是否正确
     * @param token Token
     * @return boolean 是否正确
     * @author Wang926454
     * @date 2018/8/31 9:05
     */
    public static boolean verify(String token) {
        // 帐号加JWT私钥解密
		String secret = getClaim(token, "account") + Base64.decode(encryptJWTKey);
		Algorithm algorithm = Algorithm.HMAC256(secret);
		JWTVerifier verifier = JWT.require(algorithm).build();
		verifier.verify(token);
		return true;
    }

    /**
     * 获得Token中的信息无需secret解密也能获得
     * @param token
     * @param claim
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/9/7 16:54
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            logger.error("解密Token中的公共信息出现JWTDecodeException异常:{}", e.getMessage());
            throw new CustomException("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
        }
    }

	/**
	 * 生成签名
	 * 
	 * @param account
	 * @param currentTimeMillis
	 * @return
	 */
	public static String sign(String account, String currentTimeMillis) {
		// 帐号加JWT私钥加密
		String secret = account + Base64.decode(encryptJWTKey);
		// 此处过期时间是以毫秒为单位，所以乘以1000
		Date date = new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpireTime) * 1000);
		Algorithm algorithm = Algorithm.HMAC256(secret);
		// 附带account帐号信息
		return JWT.create().withClaim("account", account).withClaim("currentTimeMillis", currentTimeMillis)
				.withExpiresAt(date).sign(algorithm);
	}
}
