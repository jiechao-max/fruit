package com.service.service;

import java.math.BigDecimal;

public interface FruitPayService {
    /**
     * @Description:计算应付价格
     * @Author: zjc
     * @Date: 2022/2/13 13:37
     * @param orderPrice:
     * @return: java.math.BigDecimal
     **/
    BigDecimal quote(BigDecimal orderPrice);


}
