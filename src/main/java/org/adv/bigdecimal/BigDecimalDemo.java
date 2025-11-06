package org.adv.bigdecimal;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.23456789");

        String str = bigDecimal.toString();

        System.out.println(str);

        String num = "234.596";

        int i = (int) Double.parseDouble(num);

        System.out.println(i);



//        double d = Double.parseDouble(num);
//
//        //int i = Integer.parseInt(num);
//        System.out.println(d);
//
//        int nm = NumberUtils.toInt(num);
//        System.out.println(nm);

        
    }
}
