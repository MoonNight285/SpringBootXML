package com.bitc.xmltest.dto;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BoxOfficeDto {
    
    @SerializedName("boxOfficeResult")
    @Expose
    private BoxOfficeResultDto boxOfficeResult;
    
    public BoxOfficeResultDto getBoxOfficeResult() {
        return boxOfficeResult;
    }
    
    public void setBoxOfficeResult(BoxOfficeResultDto boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }
    
}
