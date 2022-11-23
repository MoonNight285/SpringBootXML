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
        // JAXB 라이브러리 사용 선언
        // PharmacyFullDataDto 클래스 타입으로 데이터를 파싱하겠다는 의미
        JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);
        
        // JAXB 라이브러리를 사용해서 XML 데이터를 자바 클래스 타입의 객체로 변환하는 언마샬 객체를 생성
        Unmarshaller um = jc.createUnmarshaller();
        
        // 기존에 제공된 XML 데이터를 기반으로 PharmacyFullDataDto 클래스의 객체를 생성하므로 XML 데이터를 파싱하여 가져온
        // 데이터를 PharmacyFullDataDto 클래스 타입의 객체 fullData 에 형변환하여 저장한다.
        PharmacyFullDataDto fullData = (PharmacyFullDataDto)um.unmarshal(new File("C://java505//pharmacy.xml"));
        PharmacyFullDataHeaderDto header = fullData.getHeader();
        PharmacyFullDataBodyDto body = fullData.getBody();
        PharmacyFullDataItemsDto items = body.getItems();
        
        // 사용자가 필요로 하는 데이터만 출력
        List<PharmacyFullDataItemDto> itemList = items.getItemList();
        
        return itemList;
    }
}
