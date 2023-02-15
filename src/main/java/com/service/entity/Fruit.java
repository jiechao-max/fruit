package com.service.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Fruit {

    /**
     * 水果名称
     */
    String name;

    /**
     * 水果价格
     */
    BigDecimal price;

    /**
     * 数量
     */
    Integer num;
}
