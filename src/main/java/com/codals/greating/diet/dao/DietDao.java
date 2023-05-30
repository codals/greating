package com.codals.greating.diet.dao;

import com.codals.greating.diet.entity.Diet;
import java.util.Optional;

public interface DietDao {

    Optional<Diet> findById(Integer dietId);
}
