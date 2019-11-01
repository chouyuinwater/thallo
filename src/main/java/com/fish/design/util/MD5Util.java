package com.fish.design.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * user:hudawei1
 * date:2018/10/1
 * time:14:22
 */
public class MD5Util {
    private MD5Util() {
    }

    static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var1) {
            throw new RuntimeException(var1);
        }
    }

    public static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }

    public static byte[] md5(String data) {
        return md5(data.getBytes());
    }

    public static String md5Hex(byte[] data) {
        return HexUtil.toHexString(md5(data));
    }

    public static String md5Hex(String data) {
        return HexUtil.toHexString(md5(data));
    }

}
