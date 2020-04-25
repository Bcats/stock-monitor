package com.bcat.agent.dao;

import com.bcat.agent.entity.StockData;
import com.squareup.okhttp.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Slf4j
@Repository
public class SinaApi implements Api {

    private static final String SINA_API = "http://hq.sinajs.cn/list=";

    @Override
    public Map<String, StockData> getDataByStockCodeList(List<String> stockCode) {

        String apiCode = String.join(",", stockCode);
        String path = SINA_API + apiCode;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(path)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            Headers headers = response.headers();
            String result = response.body().string().trim();
            return stockDataFormat(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, StockData> stockDataFormat(String result) {

        Map<String, StockData> stockDataMap = new HashMap<>();
        String[] everyStock = result.split("\n");
        for (String stock : everyStock) {
            String stockCode = stock.substring(11,19);
            String regex = "(var\\shq_str_\\w{8}=\"|\";)";
            String stockDataItem = stock.replaceAll(regex, "");
            List<String> stockDataListItem = Arrays.asList(stockDataItem.split(","));
            StockData stockData = new StockData(stockDataListItem);
            stockDataMap.put(stockCode, stockData);
        }

        return stockDataMap;
    }

}
