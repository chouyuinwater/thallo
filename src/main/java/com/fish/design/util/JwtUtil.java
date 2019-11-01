package com.fish.design.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.DefaultJwtSigner;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * jwt工具类
 *
 * @author guowanyu
 * @date 2018-12-25 11:35
 **/
public class JwtUtil {

    private final static String SECRET = "123";

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 由字符串生成加密key
     *
     * @return Key
     */
    private static Key generalKey() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        return new SecretKeySpec(SECRET.getBytes(), signatureAlgorithm.getJcaName());
    }

    /**
     * 创建jwt
     *
     * @param palyload  负载
     * @return jwt jwt
     * @throws Exception 异常
     */
    public static String createJWT(String palyload) throws Exception {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Key key = generalKey();

        JwtBuilder builder = Jwts.builder()
                .setHeader(getHeadMap())
                .setPayload(palyload)
                .signWith(signatureAlgorithm, key);

        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt jwt
     * @return Claims
     * @throws Exception 异常
     */
    public static Claims parseJWT(String jwt) throws Exception {
        Key key = generalKey();

        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
    }

    private static String base64UrlEncode(Object o) throws JsonProcessingException {
        byte[] bytes = OBJECT_MAPPER.writeValueAsBytes(o);

        return TextCodec.BASE64URL.encode(bytes);
    }

    private static Map<String, Object> getHeadMap() {
        HashMap<String, Object> headMap = new LinkedHashMap<>();

        headMap.put("alg", "HS256");
        headMap.put("typ", "JWT");

        return headMap;
    }

    private static void officalDemo() throws JsonProcessingException {

        String base64UrlHeadJson = base64UrlEncode(getHeadMap());
        String base64UrlPlayload = base64UrlEncode(getPlayloadMap());

        String encodeStr = base64UrlHeadJson + "." + base64UrlPlayload;

        SignatureAlgorithm alg = SignatureAlgorithm.HS256;
        Key key = new SecretKeySpec("123".getBytes(), alg.getJcaName());
        String sign = new DefaultJwtSigner(alg, key).sign(encodeStr);

        System.out.println(base64UrlHeadJson);
        System.out.println(base64UrlPlayload);
        System.out.println(sign);

        System.out.println(base64UrlHeadJson + "." + base64UrlPlayload + "." + sign);
    }

    private static Map<String, Object> getPlayloadMap() {
        HashMap<String, Object> playloadMap = new HashMap<>(5);

        playloadMap.put("sub", "1234567890");
        playloadMap.put("name", "John Doe");
        playloadMap.put("iat", 1516239022);

        return playloadMap;
    }

    public static void main(String[] args) {
        try {

            String jwt = createJWT(new Gson().toJson(getPlayloadMap()));

            System.out.println("JWT：" + jwt);

            System.out.println("解密");

            Claims c = parseJWT(jwt);

            System.out.println(c);

            // 官方例子
            officalDemo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
