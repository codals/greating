package com.codals.greating.diet.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DietDaoImpl implements DietDao {

    private final SqlSession sqlSession;
}
