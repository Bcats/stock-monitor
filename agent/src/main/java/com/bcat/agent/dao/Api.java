package com.bcat.agent.dao;

import com.bcat.agent.model.StockData;

import java.util.List;

public interface Api {
    StockData getData(List<String> StockCode);
}
