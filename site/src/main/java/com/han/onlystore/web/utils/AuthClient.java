package com.han.onlystore.web.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Amy on 2017/3/28.
 */
public class AuthClient {

    public static final String AppID="wx2069adc5917f2373";
    public static final String AppSecret="751aeb9a0be0eb985a87e3235a0019eb";

    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = new JSONObject();
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);

        HttpEntity entity = response.getEntity();
        if(entity != null) {
            String str = EntityUtils.toString(entity);
            jsonObject = JSONObject.parseObject(str);
        }
        httpGet.releaseConnection();

        return jsonObject;
    }
}
