package com.han.onlystore.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.han.onlystore.web.utils.AuthClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Amy on 2017/3/28.
 */
@RestController
@RequestMapping("member")
public class MemberController {

    @RequestMapping("index")
    public void index(HttpServletResponse response) throws IOException {

        String backUrl = "http://anycall.ants-city.com/member/urlCallback";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + AuthClient.AppID +
                "&redirect_uri=" + URLEncoder.encode(backUrl) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";

        response.sendRedirect(url);
    }

    @RequestMapping("urlCallback")
    public void urlCallback(HttpServletRequest request) throws IOException {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + AuthClient.AppID +
                "&secret=" + AuthClient.AppSecret +
                "&code=" + code +
                "&grant_type=authorization_code";
        JSONObject jsonObject = AuthClient.doGetJson(url);
        String openid = jsonObject.getString("openid");
        String accessToken = jsonObject.getString("access_token");

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + accessToken +
                "&openid=" + openid +
                "&lang=zh_CN";
        JSONObject userInfo = AuthClient.doGetJson(infoUrl);
        if(userInfo != null) {
            String nickname = userInfo.getString("nickname");
            String province = userInfo.getString("province");
            String city = userInfo.getString("city");
            String country = userInfo.getString("country");
        }
    }
}
