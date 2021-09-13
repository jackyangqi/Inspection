package com.yang.config.token;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import cn.hutool.core.codec.Base64;

@Component
public class TokenUtil {

	//private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

	public static final String encryptJWTKey = "U0JBUElKV1RkV2FuZzkyNjQ1NA==";
	public static final String accessTokenExpireTime = "300";

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
