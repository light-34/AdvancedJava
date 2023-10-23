package org.adv.StrBuffer;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer stBf = new StringBuffer();
        stBf.append("Hello").append(" World").append(", ");
        stBf.setCharAt(stBf.length() - 2, ' ');
        System.out.println(stBf);
        //System.out.println(stBf.substring(0, stBf.length() - 2));

    }
}
