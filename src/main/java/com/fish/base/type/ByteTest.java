package com.fish.base.type;

import com.fish.tool.JsonUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author jiangbing
 * @date 2021/3/29 14:45
 * notes and tips:
 */
public class ByteTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        byte[] bytes = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
             ) {
            objectOutputStream.writeObject(userInfo);
            bytes = byteArrayOutputStream.toByteArray();
            try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
                userInfo = (UserInfo)objectInputStream.readObject();
            }
            System.out.println(bytes.length);
            String json = JsonUtil.toJson(userInfo);
            System.out.println(json);
            System.out.println(json.getBytes(StandardCharsets.UTF_8).length);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class UserInfo implements Serializable {
        public long uid = 30200001191L;
        public byte autoOpen = 0;
        public String endtime = "2021-01-01 00:00:00";
        public byte type = 0;
        public int gfrom = 100;
        public int autoOpenGfrom = 0;
        public String endtimeYearVip = "2021-01-01 00:00:00";
        public String endtimePrepay = "2021-01-01 00:00:00";
        public String endtimeFree = "2021-01-01 00:00:00";
        public int status = 0;
        public int statusMonth = 0;
        public long ordertime = System.currentTimeMillis();
        public long firstOrdertime = System.currentTimeMillis();
        public String productId = "你好你好好";
        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public byte getAutoOpen() {
            return autoOpen;
        }

        public void setAutoOpen(byte autoOpen) {
            this.autoOpen = autoOpen;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public byte getType() {
            return type;
        }

        public void setType(byte type) {
            this.type = type;
        }

        public int getGfrom() {
            return gfrom;
        }

        public void setGfrom(int gfrom) {
            this.gfrom = gfrom;
        }

        public int getAutoOpenGfrom() {
            return autoOpenGfrom;
        }

        public void setAutoOpenGfrom(int autoOpenGfrom) {
            this.autoOpenGfrom = autoOpenGfrom;
        }

        public String getEndtimeYearVip() {
            return endtimeYearVip;
        }

        public void setEndtimeYearVip(String endtimeYearVip) {
            this.endtimeYearVip = endtimeYearVip;
        }

        public String getEndtimePrepay() {
            return endtimePrepay;
        }

        public void setEndtimePrepay(String endtimePrepay) {
            this.endtimePrepay = endtimePrepay;
        }

        public String getEndtimeFree() {
            return endtimeFree;
        }

        public void setEndtimeFree(String endtimeFree) {
            this.endtimeFree = endtimeFree;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatusMonth() {
            return statusMonth;
        }

        public void setStatusMonth(int statusMonth) {
            this.statusMonth = statusMonth;
        }

        public long getOrdertime() {
            return ordertime;
        }

        public void setOrdertime(long ordertime) {
            this.ordertime = ordertime;
        }

        public long getFirstOrdertime() {
            return firstOrdertime;
        }

        public void setFirstOrdertime(long firstOrdertime) {
            this.firstOrdertime = firstOrdertime;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }
    }

}
