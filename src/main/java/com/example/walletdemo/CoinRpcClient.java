package com.example.walletdemo;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author Miccke
 * @Description TODO
 * @Date $ $
 * @Version 2.0.4
 **/
@Component
@Configuration
public class CoinRpcClient {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Value("${btc.rpc.user}")
    public  String user; //验证用户名
    @Value("${btc.rpc.password}")
    public  String password; //验证密码
    @Value("${btc.rpc.allowip}")
    public  String allowip; //验证ip
    @Value("${btc.rpc.port}")
    public  String port; //验证端口


    // 比特币身份认证
    public JsonRpcHttpClient getClient() {
        JsonRpcHttpClient client = null;
        try {
            String cred = Base64Utils.encodeToString((user + ":" + password).getBytes());
            Map<String, String> headers = new HashMap<>(1);
            headers.put("Authorization", "Basic " + cred);
            client = new JsonRpcHttpClient(new URL("http://" + allowip + ":" + port), headers);
        } catch (Exception e) {
            LOG.info("===com.bscoin.bit.env.CoinRpcClient:{} btc client !===",e.getMessage(),e);
        }
        return client;
    }

}

