package com.bitc.xmltest.dto;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BoxOfficeResultDto {
    @SerializedName("boxofficeType")
    @Expose
    private String boxofficeType;
    @SerializedName("showRange")
    @Expose
    private String showRange;
    @SerializedName("dailyBoxOfficeList")
    @Expose
    private List<DailyBoxOfficeDto> dailyBoxOfficeList = null;
    
    public String getBoxofficeType() {
        return boxofficeType;
    }
    
    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }
    
    public String getShowRange() {
        return showRange;
    }
    
    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }
    
    public List<DailyBoxOfficeDto> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }
    
    public void setDailyBoxOfficeList(List<DailyBoxOfficeDto> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }
}