package org.adv.lists;

import org.adv.dto.Employee;
import org.apache.commons.collections4.CollectionUtils;
import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>(List.of("AAAA", "BBBBB", "CCCC", "DDDD", "EEEEE")); //Works as FIFO (first in first out)
        list.addAll(List.of("KKKKK", "MMMM", "NNNNN"));
        list.forEach(System.out::println);

        String str = list.toString();
        System.out.println(str);

        ErrorCount err = new ErrorCount();

        for (int i = 1; i < 6; i++) {
            err.addError(i);
        }

        System.out.println("Error count is " + err.getError());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());*/



        /*Stack<String> stack = new Stack<>();
        stack.push("AAAAA");
        stack.push("BBBBB");
        stack.push("CCCCC");
        stack.push("DDDDD");
        stack.push("EEEEE");
        System.out.println("List Elements\n*******************************");
        list.forEach(System.out::println);
        System.out.println("Stack Elements\n*******************************");
        //System.out.println(stack.pop());
        stack.forEach(System.out::println);
        System.out.println(stack.size());

        Employee emp = new Employee(40);
        addOne(emp);
        addTwo(emp);
        System.out.println(emp.getAge());*/
        //System.out.println(writeMessage(new String[]{}));


        List<Integer> intList = new ArrayList<>();
        int recordNumber = 122;
        for (int i = 0; i < recordNumber; i++) {
            intList.add(i);
        }
        System.out.println(intList);

        int loopSize = (int) Math.ceil((double) recordNumber /20);

        int maxNum;
        for (int i = 0; i < loopSize; i++) {

            List<Integer> subList;
            maxNum = Math.min(recordNumber, (i + 1) * 20);
            subList = intList.subList((i * 20), maxNum);
            System.out.println(subList);

        }

        Object[] params = new Object[intList.size()];
        Arrays.fill(params, "A");

        Arrays.stream(params).forEach(System.out::print);


        /*String str = "SRSMA.WCS1300";
        String[] arr = str.split("\\.");
        System.out.println(arr[0] + " and length : " + arr.length);*/

    }

    public static void addOne(Employee emp) {
        int age = emp.getAge();
        emp.setAge(age + 1);
    }

    public static void addTwo(Employee emp) {
        int age = emp.getAge();
        emp.setAge(age + 2);
    }

    public static String writeMessage(String[] arr) {
        return CollectionUtils.isNotEmpty(Arrays.asList(arr)) ? "It is not Empty" : "Empty";

    }

}
