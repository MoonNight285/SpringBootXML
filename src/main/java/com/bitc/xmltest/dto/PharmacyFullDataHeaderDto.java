package com.bitc.xmltest.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "header")
public class PharmacyFullDataHeaderDto {
    private String resultCode;
    private String resultMsg;
    
    // 클래스가 아닌 타입은 name 속성을 지정하지 않아도 된다.
    @XmlElement
    public String getResultCode() {
        return resultCode;
    }
    
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    
    @XmlElement
    public String getResultMsg() {
        return resultMsg;
    }
    
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
