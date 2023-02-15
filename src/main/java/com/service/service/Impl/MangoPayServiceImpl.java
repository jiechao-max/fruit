package com.service.service.Impl;

import com.fruit.factory.PayServiceStrategyFactory;
import com.service.service.FruitPayService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zjc
 */
@Service
public class MangoPayServiceImpl implements FruitPayService, InitializingBean {


    @Override
    public BigDecimal quote(BigDecimal num) {
        BigDecimal zero = new BigDecimal("0");
        if(num.compareTo(zero)<0) {
            System.out.println("数量不能小于等于0");
            return null;
        }

        //芒果价格  实际可以去数据库拿取
        BigDecimal mangoPrice = new BigDecimal("20");

        //最终价格
        BigDecimal finalPrice = mangoPrice.multiply(num);
        System.out.println("芒果价格="+finalPrice);
        if(finalPrice.compareTo(zero)<0) {
            System.out.println("支付不应为负数!");
            return null;
        }
        //返回最终价格
        return finalPrice;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PayServiceStrategyFactory.register("mango",this);
    }

}
