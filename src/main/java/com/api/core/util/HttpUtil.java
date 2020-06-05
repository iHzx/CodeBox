package com.api.core.util;

import com.api.core.exception.CodeBoxException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * hzx 2020-05-28
 * 请求连接池大礼包
 */
@SuppressWarnings("ALL")
@Slf4j
public class HttpUtil {

    private static volatile HttpUtil httpUtil;

    private CloseableHttpClient httpClient;

    public HttpUtil(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * 连接池实例
     * @return
     */
    public static HttpUtil getInstance() {
        try {
            if (null == httpUtil) {
                Thread.sleep(1000);
                synchronized (HttpUtil.class) {
                    if(null == httpUtil) {
                        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
                        // 将最大连接数增加到200
                        cm.setMaxTotal(200);
                        // 将每个路由基础的连接增加到20
                        cm.setDefaultMaxPerRoute(20);
                        CloseableHttpClient myhttpClient = HttpClients.custom().setConnectionManager(cm).build();
                        httpUtil = new HttpUtil(myhttpClient);
                    }
                }
            }
        } catch (InterruptedException e) {
        }
        return httpUtil;
    }


//    public String httpGetKuaiDi(String url,String appCode){
//        String content = "";
//        HttpEntity entity =null;
//        HttpGet httpget = null;
//        httpget = new HttpGet(url);
//        HttpResponse httpResponse = null;
//        httpget.setHeader("Authorization", appCode);
//        try {
//            httpResponse = httpClient.execute(httpget);
//            int repStatusCode = httpResponse.getStatusLine().getStatusCode();
//            if (repStatusCode != 200) {
//                throw new CodeBoxException("HTTP返回码:" + repStatusCode);
//            }
//            entity = httpResponse.getEntity();
//            //ogger.info("应答码:{}"+httpResponse.getStatusLine().getStatusCode());
//            content = EntityUtils.toString(entity, "utf-8");
//            //log.info("应答报文:{}"+content);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            httpget.abort();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return content;
//
//    }


    public String httpGet(String url){
        String content = "";
        HttpEntity entity =null;
        HttpGet httpget = null;
        httpget = new HttpGet(url);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpget);
            int repStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (repStatusCode != 200) {
                throw new CodeBoxException("HTTP返回码:" + repStatusCode);
            }
            entity = httpResponse.getEntity();
            //ogger.info("应答码:{}"+httpResponse.getStatusLine().getStatusCode());
            content = EntityUtils.toString(entity, "utf-8");
            //log.info("应答报文:{}"+content);

        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            httpget.abort();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return content;

    }


    public String httpPost(String url){
        String content = "";
        HttpEntity entity =null;
        HttpPost httpPost = null;
        httpPost = new HttpPost(url);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            int repStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (repStatusCode != 200) {
                throw new CodeBoxException("HTTP返回码:" + repStatusCode);
            }
            entity = httpResponse.getEntity();
            log.info("应答码:{}"+httpResponse.getStatusLine().getStatusCode());
            content = EntityUtils.toString(entity, "utf-8");
            log.info("应答报文:{}"+content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            httpPost.abort();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return content;

    }

//    public String wxPayPost(String url,String message){
//        CloseableHttpResponse response;
//        String rsStr ="";
//        try {
//            HttpPost httppost = new HttpPost(url);
//            if(null != message) {
//                StringEntity stringEntity = new StringEntity(message.toString(), "UTF-8");
//                httppost.setEntity(stringEntity);
//            }
//            response = httpClient.execute(httppost);
//            HttpEntity rentity = response.getEntity();
//            if (rentity != null) {
//                rsStr = EntityUtils.toString(rentity, "utf-8");
//                //System.out.println("返回数据:"+rsStr);
//            }
//            httppost.abort();
//        } catch (IOException e) {
//
//        }
//
//        return  rsStr;
//
//    }




//    public String httpPostToken(String url,String message,String token){
//        CloseableHttpResponse response;
//        String rsStr ="";
//        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//        formparams.add(new BasicNameValuePair("data", message));
//        try {
//            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
//            HttpPost httppost = new HttpPost(url);
//            httppost.setHeader("Authorization", token);
//            httppost.setEntity(entity);
//            response = httpClient.execute(httppost);
//            HttpEntity rentity = response.getEntity();
//            if (rentity != null) {
//                rsStr = EntityUtils.toString(rentity, "utf-8");
//                //System.out.println("返回数据:"+rsStr);
//            }
//            httppost.abort();
//        } catch (IOException e) {
//
//        }
//
//        return  rsStr;
//
//    }




}
