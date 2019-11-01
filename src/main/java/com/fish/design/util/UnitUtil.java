package com.fish.design.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author one3c-yaogang5
 * @Description: TODO()
 * @Date 2018/9/5
 * @Time 15:10
 */
public class UnitUtil {

    /**
     * 将字符串按照指定长度截成指定长度的字符串数组
     * @param argsLength 要返回的数组的长度
     * @param strLength  按照该长度截取字符串
     * @param data       要被截取的字符串
     * @return argsLength = 3 strLength = 1 data = ab
     *          String[] result = {"a", "b", null}
     */
    public static String[] convertAddress(int argsLength, int strLength, String data) {
        if (argsLength <= 0 || strLength <= 0) {
            return null;
        }
        if (StringUtils.isBlank(data)) {
            return new String[argsLength];
        }
        String[] result = new String[argsLength];
        int dataLength = data.length();
        int length = (dataLength / strLength) + 1;
        for (int i = 0; i < length ; i++) {
            if (argsLength == i) {
                break;
            }
            if (i + 1 == length) {
                result[i] = data.substring(i * strLength, dataLength);
                break;
            }
            result[i] = data.substring(i * strLength, (i + 1) * strLength);
        }
        return result;
    }

    /**
     * 计算传入参数的MD5
     * @param data
     * @return
     * @throws Exception
     */
    public static String getMD5(String data) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 计算md5函数
            messageDigest.update(data.getBytes("utf-8"));
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e) {
            throw e;
        }
    }
}


