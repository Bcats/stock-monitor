package com.bcat.agent.dao;

import com.bcat.agent.model.StockData;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.sun.deploy.util.StringUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class SinaApi implements Api {

    private static final String SINA_API = "http://hq.sinajs.cn/list=";

    @Override
    public StockData getData(List<String> StockCode) {

        String ApiCode = StringUtils.join(StockCode,",");
        String path = SINA_API + ApiCode;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(path)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
