package com.bitc.xmltest.service;

import com.bitc.xmltest.dto.DailyBoxOfficeDto;

import java.util.List;

public interface BoxOfficeService {
    public List<DailyBoxOfficeDto> getDailyBoxOfficeListJson(String serviceUrl);
}
