package com.bitc.xmltest.service;

import com.bitc.xmltest.dto.BoxOfficeDto;
import com.bitc.xmltest.dto.DailyBoxOfficeDto;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

@Service
public class BoxOfficeServiceImpl implements BoxOfficeService {
    @Override
    public List<DailyBoxOfficeDto> getDailyBoxOfficeListJson(String serviceUrl) {
        List<DailyBoxOfficeDto> itemList = null;
        URL url = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null; // 웹 서버에서 응답으로 넘겨주는 데이터를 받아오는 스트림
        
        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection)url.openConnection();
            urlConn.setRequestMethod("GET");
            
            // 웹 사이트 연결이 완료
            reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            
            // 문자열을 효과적으로 사용하기 위한 클래스
            StringBuilder sb = new StringBuilder();
            String line;
            
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
            
            // Gson 객체 사용
            Gson gson = new Gson();
            // Gson을 통해서 가져온 데이터를 BoxOffice 클래스 타입으로 변환
            BoxOfficeDto boxOffice = gson.fromJson(sb.toString(), BoxOfficeDto.class);
            
            itemList = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) { reader.close(); }
                if (urlConn != null) { urlConn.disconnect(); }
            } catch (IOException ex) {
            
            }
        }
        
        return itemList;
    }
}
