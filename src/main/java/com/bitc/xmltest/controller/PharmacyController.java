package com.bitc.xmltest.controller;

import com.bitc.xmltest.dto.DailyBoxOfficeDto;
import com.bitc.xmltest.dto.PharmacyFullDataItemDto;
import com.bitc.xmltest.service.BoxOfficeService;
import com.bitc.xmltest.service.PharmacyFullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.Param;

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
    private BoxOfficeService boxOfficeService;
    @Autowired
    private PharmacyFullDataService pharmacyFullDataService;
    
    @Value("${openApi.endPoint}")
    private String endPoint;
    
    @Value("${openApi.serviceKey}")
    private String serviceKey;
    
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
    
    @ResponseBody
    @RequestMapping(value = "/pharmacy/fullDataUrl", method = RequestMethod.POST)
    public Object getFullDataAjax(@RequestParam("pageNumber") int pageNumber, @RequestParam("rowCount") int rowCount) throws Exception {
        // open API 서버로 요청하기 위한 URL 생성 작업이 필요..
        // https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/ // 서버주소(endPoint)
        // getParmacyFullDown // 서비스 요청 주소
        // ?serviceKey=pAR7xB7Uwyh4RcIMj1YNS9nYmjzzbIEm%2BTOpaJa1IxsC%2FB7J96c6jR5lABRfJjfLbB323p8xThlPinRbLSe6pw%3D%3D // 개인 키
        // &pageNo=1& // 옵션 1
        // numOfRows=10 // 옵션 2
        
        String reqService = "/getParmacyFullDown";
        String service = "?serviceKey=";
        String option1 = "&pageNo=";
        String option2 = "&numOfRows=";
        
        String url = endPoint + reqService + service + serviceKey + option1 + pageNumber + option2 + rowCount;
        
        List<PharmacyFullDataItemDto> pharmacyDatas = pharmacyFullDataService.getItemListUrl(url);
        
        return pharmacyDatas;
    }
    
    @RequestMapping(value = "/movie/dailyBoxOffice", method = RequestMethod.GET)
    public String dailyBoxOfficeView() {
        return "/movie/dailyBoxOffice";
    }
    
    @ResponseBody
    @RequestMapping(value = "/movie/dailyBoxOfficeJson", method = RequestMethod.POST)
    public Object getDailyBoxOfficeListJson() {
        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20221121";
        List<DailyBoxOfficeDto> dailyBoxOfficeList = boxOfficeService.getDailyBoxOfficeListJson(url);
        return dailyBoxOfficeList;
    }
}
