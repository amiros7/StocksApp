package com.example.mstockslib.models;

public class StockDataResponse {
    private StockData stockData;
    private String companyThumbnail;
    private CompanyProfile profile;

    // Getters and setters
    public StockData getStockData() {
        return stockData;
    }

    public boolean valid() {
        return profile!=null&&stockData!=null&&companyThumbnail!=null;
    }

    public CompanyProfile getProfile() {
        return profile;
    }

    public void setProfile(CompanyProfile profile) {
        this.profile = profile;
    }

    public void setStockData(StockData stockData) {
        this.stockData = stockData;
    }

    public String getCompanyThumbnail() {
        return companyThumbnail;
    }

    public void setCompanyThumbnail(String companyThumbnail) {
        this.companyThumbnail = companyThumbnail;
    }
}
