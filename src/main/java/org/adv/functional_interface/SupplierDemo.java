package org.adv.functional_interface;

public class SupplierDemo {
    public static void main(String[] args) {
        PrintingSupplier<String> printingSupplier = () -> "Hello World";
        System.out.println(printingSupplier.print());

        FunctionalMethods.printList(5, Math::random).forEach(System.out::println);
    }
}
