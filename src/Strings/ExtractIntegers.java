package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractIntegers {
    public static List<Integer> extract(String str){
        if (str == null || str.isBlank())
            return Collections.emptyList();
        List<Integer> integers = new ArrayList<>();
        StringBuilder temp = new StringBuilder(String.valueOf(Integer.MAX_VALUE).length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                temp.append(c);
            else{
                if (temp.length() > 0){
                    integers.add(Integer.parseInt(temp.toString()));
                    temp.delete(0 , temp.length());
                } // end of if
            } // end of else
        } // end of for
        if (!temp.isEmpty())
            integers.add(Integer.parseInt(temp.toString()));
        return integers;
    }

    public static void main (String[] args) {
        System.out.println(extract("12dsdsx9df f 252cs10f5z0m123456784"));
    }
}
