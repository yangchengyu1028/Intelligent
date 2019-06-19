package com.novo.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

public class GetAndPost {
    /**
     * 访问接口获取json字符串方法(get)
     * @param addess
     * @return
     */
    public String get(String addess) {
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(addess);
            in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        String data = sb.toString();
        return data;
    }

    /**
     * 向第三方接口post数据通用方法,传入JSONObject
     * @param jsonString
     * @param url
     * @return
     */
    public String post(JSONObject jsonString, String url) {
        HttpClient httpClient = null;
        HttpPost postMethod = null;
        HttpResponse response = null;
        String reponseContent = null;
        try {
            httpClient = HttpClients.createDefault();
            postMethod = new HttpPost(url);//传入URL地址
            //设置请求头
            postMethod.addHeader("Content-type", "application/json; charset=utf-8");
            //传入请求参数
            postMethod.setEntity(new StringEntity(jsonString.toString(), Charset.forName("UTF-8")));
            response = httpClient.execute(postMethod);//获取响应
//            int statusCode = response.getStatusLine().getStatusCode();
//            System.out.println("HTTP Status Code:" + statusCode);
//            if (statusCode != HttpStatus.SC_OK) {
//                System.out.println("HTTP请求未成功！HTTP Status Code:" + response.getStatusLine());
//            }
            HttpEntity httpEntity = response.getEntity();
            reponseContent = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);//释放资源
//            System.out.println("响应内容：" + reponseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reponseContent;
    }

    public  String postData(String uri, Map<String,Object> map) {
        //所有的参数都放在map中，然后转换成json字符串传递到接口中
        String str = JSONObject.fromObject(map).toString();
        //System.out.println("json参数："+str);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(new StringEntity(str, Charset.forName("utf-8")));
        try {
            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            //System.out.println("http返回码："+statusCode);
            //如果返回状态是200，打印返回信息
            if (statusCode==200) {
                HttpEntity entity = response.getEntity();
                String entityStr = EntityUtils.toString(entity);
                //System.out.println("客户端接收内容:"+entityStr);
                return entityStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




}
