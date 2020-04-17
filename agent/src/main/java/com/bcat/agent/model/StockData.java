package com.bcat.agent.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString
public class StockData {

    /* 股票名称 */
    private String stockName;
    /* 今开价 */
    private BigDecimal todayOpenPrice;
    /* 昨收价 */
    private BigDecimal yesterdayClosePrice;
    /* 当前价 */
    private BigDecimal nowPrice;
    /* 今日最高价 */
    private BigDecimal todayMaxPrice;
    /* 今日最低价 */
    private BigDecimal todayMinPrice;
    /* 股票成交数（股） */
    private Integer stockTransactionNumber;
    /* 股票成交金额（元） */
    private Integer stockTransactionAmount;
    /* 买一数（股） */
    private Integer buyOneNumber;
    /* 买一价（元） */
    private BigDecimal buyOnePrice;
    /* 买二数（股） */
    private Integer buyTwoNumber;
    /* 买二价（元） */
    private BigDecimal buyTwoPrice;
    /* 买三数（股） */
    private Integer buyThreeNumber;
    /* 买三数（元） */
    private BigDecimal buyThreePrice;
    /* 买四数（股） */
    private Integer buyFourNumber;
    /* 买四数（元） */
    private BigDecimal buyFourPrice;
    /* 买五数（股） */
    private Integer buyFiveNumber;
    /* 买五数（元） */
    private BigDecimal buyFivePrice;
    /* 卖一数（股） */
    private Integer sellOneNumber;
    /* 卖一价（元） */
    private BigDecimal sellOnePrice;
    /* 卖二数（股） */
    private Integer sellTwoNumber;
    /* 卖二价（元） */
    private BigDecimal sellTwoPrice;
    /* 卖三数（股） */
    private Integer sellThreeNumber;
    /* 卖三数（元） */
    private BigDecimal sellThreePrice;
    /* 卖四数（股） */
    private Integer sellFourNumber;
    /* 卖四数（元） */
    private BigDecimal sellFourPrice;
    /* 卖五数（股） */
    private Integer sellFiveNumber;
    /* 卖五数（元） */
    private BigDecimal sellFivePrice;

    public StockData(List<String> stockDataList){

        if (stockDataList.get(0) != null){
            this.stockName = stockDataList.get(0);
        }
        if (stockDataList.get(1) != null){
            this.todayOpenPrice = new BigDecimal(stockDataList.get(1));
        }

        this.todayOpenPrice = new BigDecimal(stockDataList.get(1));

        this.yesterdayClosePrice = new BigDecimal(stockDataList.get(2));

        this.nowPrice = new BigDecimal(stockDataList.get(3));

        this.todayMaxPrice = new BigDecimal(stockDataList.get(4));

        this.todayMinPrice = new BigDecimal(stockDataList.get(5));

        this.stockTransactionNumber = Integer.valueOf(stockDataList.get(8));

        this.stockTransactionAmount = Double.valueOf(stockDataList.get(9)).intValue();

        this.buyOneNumber = Integer.valueOf(stockDataList.get(10));

        this.buyOnePrice = new BigDecimal(stockDataList.get(11));

        this.buyTwoNumber = Integer.valueOf(stockDataList.get(12));

        this.buyTwoPrice = new BigDecimal(stockDataList.get(13));

        this.buyThreeNumber = Integer.valueOf(stockDataList.get(14));

        this.buyThreePrice = new BigDecimal(stockDataList.get(15));

        this.buyFourNumber = Integer.valueOf(stockDataList.get(16));

        this.buyFourPrice = new BigDecimal(stockDataList.get(17));

        this.buyFiveNumber = Integer.valueOf(stockDataList.get(18));

        this.buyFivePrice = new BigDecimal(stockDataList.get(19));

        this.sellOneNumber = Integer.valueOf(stockDataList.get(20));

        this.sellOnePrice = new BigDecimal(stockDataList.get(21));

        this.sellTwoNumber = Integer.valueOf(stockDataList.get(22));

        this.sellTwoPrice = new BigDecimal(stockDataList.get(23));

        this.sellThreeNumber = Integer.valueOf(stockDataList.get(24));

        this.sellThreePrice = new BigDecimal(stockDataList.get(25));

        this.sellFourNumber = Integer.valueOf(stockDataList.get(26));

        this.sellFourPrice = new BigDecimal(stockDataList.get(27));

        this.sellFiveNumber = Integer.valueOf(stockDataList.get(28));

        this.sellFivePrice = new BigDecimal(stockDataList.get(29));


    }
}
