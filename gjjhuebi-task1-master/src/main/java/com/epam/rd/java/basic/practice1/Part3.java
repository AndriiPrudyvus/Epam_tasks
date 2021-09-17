package com.epam.rd.java.basic.practice1;

public class Part3 {
    
    static String[] displayingParameters(String[] arguments) {

        String[] values;

        if (arguments[arguments.length - 1].equals(" ") && arguments.length > 1) {
            values = new String[arguments.length + arguments.length - 3];
        } else {
            values = new String[arguments.length + arguments.length - 1];
        }

        int j = 0;
        int l = 0;

        for (int i = 0; i < arguments.length - 1; i++) {
            l++;
            if (arguments[arguments.length - 1].equals(" ")) {
                values[j] = arguments[i];
                j++;
                if (l <= arguments.length - 2) {
                    values[j] = " ";
                }
                j++;
            } else {
                values[j] = arguments[i];
                j++;
                values[j] = " ";
                j++;
            }
        }

        if (arguments[arguments.length - 1].equals(" ")) {
            System.out.print(" ");
        } else {
            values[j] = arguments[arguments.length - 1];
        }

        if (arguments[0].equals(" ") && arguments.length == 1 || arguments[0].equals("")) {
            return new String[]{};
        }
        return values;
    }

    public static void main(String[] args) {
        
        String[] strings = displayingParameters(args);

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
    }
}
