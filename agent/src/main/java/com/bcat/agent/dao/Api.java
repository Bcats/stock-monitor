package com.bcat.agent.dao;

import com.bcat.agent.entity.StockData;

import java.util.List;
import java.util.Map;

public interface Api {

    // 返回例如 { "sz002460": stockData@12354 } 的数据
    Map<String, StockData> getDataByStockCodeList(List<String> StockCode);

}
