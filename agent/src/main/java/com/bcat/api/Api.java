package com.bcat.api;

import com.bcat.model.StockData;

import java.util.List;

public interface Api {
    StockData getData(List<String> StockCode);
}
