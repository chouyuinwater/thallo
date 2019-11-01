package com.fish.commons;


import com.google.gson.JsonObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class HttpClientUtil {

    private static final String SECRET_KEY1 = "11";

    private static final String SECRET_KEY2 = "11";

    private static final String TEST_URL = "11";

    private static final String HTTP_VERB_POST = "POST";

    private static final String HTTP_VERB_GET = "POST";

    private static final String PLATFORM_ID = "";

    private static final String GVS_ID = "111";

    public static void main(String[] args) {
//        httpClientPost();
//        httpClientGet();
        postGatway();
    }

    public static String getChecksum(String jsonData, String httpVerb, String url, String platformId) {
        if (StringUtils.isBlank(httpVerb) || StringUtils.isBlank(url)) {
            throw new RuntimeException("参数为空");
        }

        try {
            String baseString = url + httpVerb + platformId + SECRET_KEY1 + jsonData;

            return DigestUtils.sha256Hex(baseString.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("参数为空");
        }
    }

    public static void httpClientPost() {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("epOrderId", "11");
            String checksum = getChecksum(jsonObject.toString(), HTTP_VERB_POST, TEST_URL, PLATFORM_ID);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(TEST_URL);
            httppost.addHeader("platformId", PLATFORM_ID);
            httppost.addHeader("checksum", checksum);
            httppost.addHeader("msgId", UUID.randomUUID().toString());
            httppost.addHeader("msgType", "111");

            // 设置超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(30000)
                    .setConnectionRequestTimeout(30000)
                    .setSocketTimeout(30000)
                    .build();
            httppost.setConfig(requestConfig);


            HttpEntity httpEntity = EntityBuilder.create()
                    .setText(jsonObject.toString())
                    .setContentType(ContentType.APPLICATION_JSON)
                    .setContentEncoding("uft-8")
                    .build();
            httppost.setEntity(httpEntity);


            CloseableHttpResponse response = httpclient.execute(httppost);
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
                System.out.println("ERROR");
            }

            HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity);
            System.out.println(code);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void httpClientGet() {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
//            URIBuilder uriBuilder = new URIBuilder(TEST_URL);
//            URI uri = uriBuilder.addParameter("name", "bingbing").build();
            HttpGet httpGet = new HttpGet("https://www.bing.com/");
            // OR 直接使用URL
            // HttpGet httpGet = new HttpGet(TEST_URL);
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //请求体内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                //内容写入文件
                FileUtils.writeStringToFile(new File("E:\\devtest\\bing.html"), content, "UTF-8");
                System.out.println("内容长度："+content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 要注意关闭资源
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpclient);
        }
    }


    public static void postGatway() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("");
        httppost.addHeader("checksum", "");



        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .setSocketTimeout(30000)
                .build();
        httppost.setConfig(requestConfig);


        HttpEntity httpEntity = EntityBuilder.create()

                .setText("")
                .setContentType(ContentType.APPLICATION_JSON)
                .setContentEncoding("uft-8")
                .build();
        httppost.setEntity(httpEntity);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
                System.out.println("ERROR");
            }

            HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity);
            System.out.println(code);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpclient);
        }
    }
}
