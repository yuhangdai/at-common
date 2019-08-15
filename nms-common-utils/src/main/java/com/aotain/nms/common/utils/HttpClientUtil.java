package com.aotain.nms.common.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/04/15
 */
public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String httpPost(String url, NameValueObjectPair[] data, String charset){
        String result = "";
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        // 设置请求的header
        postMethod.addRequestHeader("Content-Type", "application/json;charset=utf-8");
        JSONObject jsonParam = new JSONObject();
        for (int i=0;data!=null&&i<data.length;i++){
            jsonParam.put(data[i].getName(), data[i].getObjectValue());
        }

        try {
            RequestEntity entity = new StringRequestEntity(jsonParam.toString(),"application/json", "utf-8");
            postMethod.setRequestEntity(entity);
            //执行Method
            int statusCode = httpClient.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                logger.error("Method failed: "
                        + postMethod.getStatusLine());
            }
            //读取内容
            byte[] responseBody = postMethod.getResponseBody();
            //处理内容
            result = new String(responseBody,charset);
        } catch (HttpException e) {
            //发生致命的异常，可能是协议不对或者返回的内容有问题
            logger.error("Please check your provided http address!",e);
        } catch (IOException e) {
            //发生网络异常
            logger.error("the io exception occur when called the post method",e);
        } finally {
            //释放连接
            postMethod.releaseConnection();
        }
        return result;
    }
    
    
}
