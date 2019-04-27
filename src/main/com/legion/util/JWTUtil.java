package legion.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {

	// 过期时间
	private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000; //12小时

	/**
	 * 
	 * @param token
	 * @return token中包含的用户名
	 */
	public static String getUserFromToken(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim("username").asString();
		} catch (JWTDecodeException e) {
			return null;
		}
	}

	/**
	 * 校验token是否正确
	 * 
	 * @param token
	 * @param username
	 * @param secret
	 * @return token是否正确
	 */
	public static boolean verify(String token, String username, String secret) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
			DecodedJWT jwt = verifier.verify(token);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 创建token
	 * 
	 * @param username
	 * @param secret
	 * @return 加密的token
	 */
	public static String sign(String username, String secret) {
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
