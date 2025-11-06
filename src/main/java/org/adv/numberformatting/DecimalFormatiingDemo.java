package org.adv.numberformatting;

import java.text.DecimalFormat;

public class DecimalFormatiingDemo {
    public static void main(String[] args) {
        double number = 1234.56789;
        DecimalFormat df = new DecimalFormat("###.#");
        double parsed = Double.parseDouble(df.format(number));
        System.out.println(parsed);
    }
}
