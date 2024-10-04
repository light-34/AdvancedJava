package org.adv.numberformatting;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        double myNumber = -1234.56;
        NumberFormat form;
        for (int i = 0; i < 4; ++i) {
            System.out.println("FORMAT");
            for (int j = 0; j < locales.length; ++j) {
                if (locales[j].getCountry().isEmpty()) {
                    continue;
                }
                System.out.println(locales[j].getDisplayName());
                switch(i) {
                    case 0 -> form = NumberFormat.getInstance(locales[j]);
                    case 1 -> form = NumberFormat.getIntegerInstance(locales[j]);
                    case 2 -> form = NumberFormat.getPercentInstance(locales[j]);
                    default -> form = NumberFormat.getCurrencyInstance(locales[j]);
                }
                if (form instanceof DecimalFormat) {
                    System.out.println(": " + ((DecimalFormat) form).toPattern());
                }
                System.out.println(" -> " + form.format(myNumber));
                try {
                    System.out.println(" -> " + form.parse(form.format(myNumber)));
                } catch (ParseException e) {}
            }
        }
    }
}
