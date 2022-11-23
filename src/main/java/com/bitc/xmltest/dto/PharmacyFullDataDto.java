package com.bitc.xmltest.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class PharmacyFullDataDto {
    private PharmacyFullDataHeaderDto header;
    private PharmacyFullDataBodyDto body;
    
    // get에만 어노테이션 붙이면 set은 알아서 적용
    @XmlElement(name = "header")
    public PharmacyFullDataHeaderDto getHeader() {
        return header;
    }
    
    public void setHeader(PharmacyFullDataHeaderDto header) {
        this.header = header;
    }
    
    @XmlElement(name = "body")
    public PharmacyFullDataBodyDto getBody() {
        return body;
    }
    
    public void setBody(PharmacyFullDataBodyDto body) {
        this.body = body;
    }
}
