package ru.academy.entity;

public class CountryInfo {

    private String countryName;

    private String currencyName;

    public CountryInfo(String countryName, String currencyName) {
        this.countryName = countryName;
        this.currencyName = currencyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
