package org.adv.codebase;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CodeBasePractice {
    public static void main(String[] args) {
        String[] words = {"helloworld", "hello,cat,bat,goodbye,world,h,e,l"};
        Methods methods = new Methods();
        String[] returnWords = methods.returnWords(words);
        System.out.println(Arrays.toString(returnWords));
    }

}

class Methods {
    public String[] returnWords(String[] words) {
        List<String> listOfWords = Arrays.stream(words[1].split(","))
                .filter(w -> w.length() > 1)
                .toList();
        List<String> result = new ArrayList<>();
        String text = words[0];
        int i = 0;

        while (i < text.length() && result.size() < 2) {
            final int pos = i;
            Optional<String> match = listOfWords.stream()
                    .filter(w -> text.startsWith(w, pos))
                    .findFirst();
            if (match.isPresent()) {
                result.add(match.get());
                i += match.get().length();
            } else {
                i++;
            }
        }
        return result.toArray(new String[2]);
    }
}
