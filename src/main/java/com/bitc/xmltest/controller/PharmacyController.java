package com.bitc.xmltest.controller;

import com.bitc.xmltest.dto.PharmacyFullDataItemDto;
import com.bitc.xmltest.service.PharmacyFullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
