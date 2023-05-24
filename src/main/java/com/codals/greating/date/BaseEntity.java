package com.codals.greating.date;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity {

    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
