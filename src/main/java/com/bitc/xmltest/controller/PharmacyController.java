package com.bitc.xmltest.controller;

import com.bitc.xmltest.dto.PharmacyFullDataItemDto;
import com.bitc.xmltest.service.PharmacyFullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// jaxb : 자바에서 xml 데이터를 파싱을 도와주는 라이브러리
// Marshal : 자바 클래스를 XML 데이터로 변환
// UnMarshal : XML 데이터를 자바 클래스 타입의 객체로 변환

// @XmlRootElement : XML 데이터에서 부모가 되는 태그를 뜻한다.
// @XmlElement : XML 데이터에서 실제 데이터가 들어있는 태그를 뜻함
// @XmlAttribute : XML 데이터에서 지정한 태그의 속성을 뜻한다.

@Controller
public class PharmacyController {
    @Autowired
    private PharmacyFullDataService pharmacyFullDataService;
    
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
    
    @RequestMapping(value = "/pharmacy/fullDataFile", method = RequestMethod.GET)
    public ModelAndView getFullData() throws Exception {
        ModelAndView mv = new ModelAndView("pharmacy/fullDataFile");
        List<PharmacyFullDataItemDto> itemList = pharmacyFullDataService.getItemList();
        mv.addObject("pharmacyDatas", itemList);
        return mv;
    }
    
    @RequestMapping(value = "/pharmacy/fullDataUrl", method = RequestMethod.GET)
    public String viewFullData() throws Exception {
        return "pharmacy/fullDataUrl";
    }
    
    @RequestMapping(value = "/pharmacy/fullDataUrl", method = RequestMethod.POST)
    public Object getFullDataAjax() throws Exception {
        return "";
    }
}
