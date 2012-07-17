package com.ds.cvbank.model;

/**
 * @author Dogukan Sonmez
 */


public class SearchBox {

    private String thisExactWordOrPhrase;

    private String anyOfTheseWords;

    private String allTheseWords;

    private String noneOfTheseWords;

    private String numberOfResult;

    public String getThisExactWordOrPhrase() {
        return thisExactWordOrPhrase;
    }

    public void setThisExactWordOrPhrase(String thisExactWordOrPhrase) {
        this.thisExactWordOrPhrase = thisExactWordOrPhrase;
    }

    public String getAnyOfTheseWords() {
        return anyOfTheseWords;
    }

    public void setAnyOfTheseWords(String anyOfTheseWords) {
        this.anyOfTheseWords = anyOfTheseWords;
    }

    public String getAllTheseWords() {
        return allTheseWords;
    }

    public void setAllTheseWords(String allTheseWords) {
        this.allTheseWords = allTheseWords;
    }

    public String getNoneOfTheseWords() {
        return noneOfTheseWords;
    }

    public void setNoneOfTheseWords(String noneOfTheseWords) {
        this.noneOfTheseWords = noneOfTheseWords;
    }

    public String getNumberOfResult() {
        return numberOfResult;
    }

    public void setNumberOfResult(String numberOfResult) {
        this.numberOfResult = numberOfResult;
    }
}
