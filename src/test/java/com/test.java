package com;

import com.fruit.factory.PayServiceStrategyFactory;
import com.service.service.FruitPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootTest
public class test {

    @Test
    public void testPrice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择水果种类：1、苹果  2、草莓  3、芒果  4、退出为了体验，这里不做真的退出，只是做清除数据操作,同时计算是否优惠后(满100-20)的价格))");
        BigDecimal zero = new BigDecimal("0");
        BigDecimal sumPrice = new BigDecimal("0");
        BigDecimal appleFinalPrice = new BigDecimal("0");
        BigDecimal strawberryFinalPrice = new BigDecimal("0");
        BigDecimal mangoFinalPrice = new BigDecimal("0");

        while (scanner.hasNext()){
            int input =scanner.nextInt();
            /*
            控制台判断选择的水果种类
            * */
            if(input ==1) {
                FruitPayService apple = PayServiceStrategyFactory.getFruitType("apple");
                System.out.println("请输入购买苹果的数量");
                int i = scanner.nextInt();
                BigDecimal num = new BigDecimal(i);
                /*
                * 计算此次水果价格
                * */
                appleFinalPrice = apple.quote(num);
                //计算总价
                try{
                    sumPrice = sumPrice.add(appleFinalPrice);
                    System.out.println("sumPrice="+sumPrice);
                }catch (NullPointerException e) {
                    System.out.println("最终价格返回为NULL，水果数量不能为负数");
                }
                catch(Exception e){
                    System.out.println("运行出现异常，请联系管理员");
                }finally {
                    //System.out.println("运行出现异常，请联系管理员");
                }

            } else if(input ==2) {
                FruitPayService strawberry = PayServiceStrategyFactory.getFruitType("strawberry");
                System.out.println("请输入购买草莓的数量");
                int i = scanner.nextInt();
                BigDecimal num = new BigDecimal(i);
                strawberryFinalPrice = strawberry.quote(num);
                //计算总价
                try{
                    sumPrice = sumPrice.add(strawberryFinalPrice);
                    System.out.println("sumPrice="+sumPrice);
                }catch (NullPointerException e) {
                    System.out.println("最终价格返回为NULL，水果数量不能为负数");
                }
                catch(Exception e){
                    System.out.println("运行出现异常，请联系管理员");
                }finally {
                    //System.out.println("运行出现异常，请联系管理员");
                }

            } else if(input ==3) {
                FruitPayService mango = PayServiceStrategyFactory.getFruitType("mango");
                System.out.println("请输入购买芒果的数量");
                int i = scanner.nextInt();
                BigDecimal num = new BigDecimal(i);
                mangoFinalPrice = mango.quote(num);
                //计算总价
                try{
                    sumPrice = sumPrice.add(mangoFinalPrice);
                    System.out.println("sumPrice="+sumPrice);
                }catch (NullPointerException e) {
                    System.out.println("最终价格返回为NULL，水果数量不能为负数");
                }
                catch(Exception e){
                    System.out.println("运行出现异常，请联系管理员");
                }finally {
                    //System.out.println("运行出现异常，请联系管理员");
                }
            } else if(input ==4) {
                System.out.println("是否执行满100优惠20  1、是  2、否");
                int select  = scanner.nextInt();
                if(select ==1){
                    BigDecimal times = sumPrice.divide(new BigDecimal("100")).setScale(0,BigDecimal.ROUND_FLOOR);
                    sumPrice=sumPrice.subtract(times.multiply(new BigDecimal("20")));
                    System.out.println("最终价格=" + sumPrice);
                }else if (select ==2){
                    System.out.println("最终价格=" + sumPrice);
                }

                /*
                * 清除数据
                * */
                appleFinalPrice.multiply(zero);
                strawberryFinalPrice.multiply(zero);
                mangoFinalPrice.multiply(zero);
                sumPrice.multiply(zero);
                //System.exit(0);
            }
            System.out.println("请继续选择水果种类：1、苹果  2、草莓  3、芒果  4、退出(为了体验，这里不做真的退出，只是做清除数据操作,同时计算是否优惠后(满100-20)的价格))");

        }
    }
}
