package com.bitc.xmltest.service;

import com.bitc.xmltest.dto.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class PharmacyFullDataServiceImpl implements PharmacyFullDataService {
    
    @Override
    public List<PharmacyFullDataItemDto> getItemList() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);
    
        Unmarshaller um = jc.createUnmarshaller();
        PharmacyFullDataDto fullData = (PharmacyFullDataDto)um.unmarshal(new File("C://java505//pharmacy.xml"));
        PharmacyFullDataHeaderDto header = fullData.getHeader();
        PharmacyFullDataBodyDto body = fullData.getBody();
        PharmacyFullDataItemsDto items = body.getItems();
        List<PharmacyFullDataItemDto> itemList = items.getItemList();
        
        return itemList;
    }
}
