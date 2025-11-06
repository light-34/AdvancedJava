package org.adv.tryPackage;

import org.apache.commons.lang3.StringUtils;

public class IfTryDemo {
    public static void main(String[] args) {
        String Aaa = "Hello";
        String Bbb = "Merhaba";
        String Ccc = "Privet.pdf";

        String Ddd = "Merxaba";

        /*if (!StringUtils.equals(Aaa, "Hello") || !StringUtils.equals(Aaa, "Merhaba") || !StringUtils.equals(Aaa, "Privet")) {
            System.out.println(Aaa + "  or");
        }

        if (!StringUtils.equals(Ddd, "Hello") && !StringUtils.equals(Ddd, "Merhaba") && !StringUtils.equals(Ddd, "Privet")) {
            System.out.println(Ddd);
        }*/

        if (StringUtils.endsWith(Ccc, ".pdf")){
            System.out.println("It contains T letter");
        }

    }
}
