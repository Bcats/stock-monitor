package com.bcat.agent.dao;

import com.bcat.agent.model.StockData;

import java.util.List;
import java.util.Map;

public interface Api {

    Map<String, StockData> getDataByStockCodeList(List<String> StockCode);

}
