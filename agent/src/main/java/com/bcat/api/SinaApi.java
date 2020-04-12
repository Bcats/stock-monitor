package com.bcat.api;

import com.bcat.model.StockData;
import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SinaApi implements Api {

    private static final String SINA_API = "http://hq.sinajs.cn/list=";

    @Override
    public StockData getData(List<String> StockCode) {

        String ApiCode = StringUtils.join(StockCode,",");
        String path = SINA_API + ApiCode;

        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
