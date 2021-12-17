package com.example.demo.Service.Interface;

import com.example.demo.Persistence.model.SearchEntity;
import com.example.demo.help.Response;

public interface ISearchService {
    Response<Object> queryData(SearchEntity searchData);
}
