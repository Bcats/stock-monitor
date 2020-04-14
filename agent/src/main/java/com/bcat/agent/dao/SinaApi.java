package com.bcat.agent.dao;

import com.bcat.agent.model.StockData;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Repository
public class SinaApi implements Api {

    private static final String SINA_API = "http://hq.sinajs.cn/list=";

    @Override
    public List<StockData> getData(List<String> stockCode) {

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
            return stockDataTransction(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<StockData> stockDataTransction(Response response) {
        List<StockData> stockDataList = new ArrayList<>();
        try {
            String result = response.body().string().trim();
            String[] everyStock = result.split("\n");
            for (String stock : everyStock) {
                String regex = "(var\\shq_str_\\w{8}=\"|\";)";
                String stockDataItem = stock.replaceAll(regex, "");
                List<String> stockDataListItem = Arrays.asList(stockDataItem.split(","));
                StockData stockData = new StockData(stockDataListItem);
                stockDataList.add(stockData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stockDataList;
    }

}
