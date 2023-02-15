package com.fruit.factory;

import com.service.service.FruitPayService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zjc
 */
public class PayServiceStrategyFactory {
    private static Map<String, FruitPayService> SERVICES = new ConcurrentHashMap<>();

    private PayServiceStrategyFactory() {}

    private static class PayServiceStrategyFactoryHolder{
        private static final PayServiceStrategyFactory FACTORY = new PayServiceStrategyFactory();
    }

    public static PayServiceStrategyFactory getInstance(){
        return PayServiceStrategyFactoryHolder.FACTORY;
    }

    public static FruitPayService getFruitType(String fruitType){
        return SERVICES.get(fruitType);
    }

    public static void register(String fruitType,FruitPayService fruitPayService){
        Assert.notNull(fruitType,"userType can not be null");
        SERVICES.put(fruitType,fruitPayService);
    }
}
