package org.adv.coloredtext;

public class ColoredText {
    public static void main(String[] args) {
        System.out.println(ColorCode.ANSI_RED + "This is RED" + ColorCode.RESET);
        System.out.println(ColorCode.ANSI_RED_BG + ColorCode.ANSI_BLACK + "This is RED Background" + ColorCode.RESET);
        System.out.println("This is normal");
    }
}
