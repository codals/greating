package com.codals.greating.util.pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.codals.greating.diy.dto.SearchRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class Pagination<T> {
    private final SqlSession sqlSession;

    public List<T> getItems(String queryStatement, int page, int pageSize) {
            	int offset = (page - 1) * pageSize;
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("offset", offset);
        parameterMap.put("limit", pageSize);
        return sqlSession.selectList(queryStatement, parameterMap);
    }
    
    public List<T> getItemsWithDto(String queryStatement, SearchRequestDto dto, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        int limit = pageSize;
        Map<String, Object> parameterMap = new HashMap<>();
        
        log.info(dto);
        
        parameterMap.put("dto", dto);
        parameterMap.put("offset", offset);
        parameterMap.put("limit", limit);
        return sqlSession.selectList(queryStatement, parameterMap);
    }

    public int getTotalCount(String queryStatement, SearchRequestDto dto) {
        return sqlSession.selectOne(queryStatement, dto);
    }
}