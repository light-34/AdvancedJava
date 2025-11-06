package org.adv.labels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LabelsDemo {
    //private static final Logger LOGGER = LogManager.getLogger(LabelsDemo.class.getName());
    public static void main(String[] args) {

        List<String> list = List.of("Ali", "Veli", "Bill", "Jill", "David");

        boolean val = true;

        for (int i = 0; i < list.size() && val ; i++) {
            for (int j = 0; j < list.size(); j++) {
                System.out.printf("The i is %d and j is %d \n", i, j);
                if (j == 3) {
                    val = false;
                    break;
                }

            }

        }
    }
}
