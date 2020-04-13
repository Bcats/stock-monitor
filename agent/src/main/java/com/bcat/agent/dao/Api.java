package com.bcat.agent.dao;

import com.bcat.agent.model.StockData;

import java.util.List;

public interface Api {

    List<StockData> getData(List<String> StockCode);

}
