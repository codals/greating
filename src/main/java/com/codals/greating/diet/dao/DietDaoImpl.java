package com.codals.greating.diet.dao;

import com.codals.greating.diet.entity.Diet;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DietDaoImpl implements DietDao {

    private final SqlSession session;

    @Override
    public Optional<Diet> findById(Integer dietId) {
        return Optional.ofNullable(session.selectOne("diet.selectById", dietId));
    }
}
