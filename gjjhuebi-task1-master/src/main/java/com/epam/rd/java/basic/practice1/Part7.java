package com.epam.rd.java.basic.practice1;

public class Part7 {
    
 
    public static int parseFromCommandLine(String[] arguments) {

      if (arguments.length >= 1) {
            int number = 0;

            for (int i = 0; i < arguments.length; i++) {
                number = number * 10 + Integer.valueOf(arguments[i]);
            }
            return number;
        }
        return 0;
    }
    
    
    static String parseFromCommandLines(String[] arguments) {

        StringBuilder values = new StringBuilder();

        for (int i = 0; i < arguments.length; i++) {
            values.append(arguments[i]);
        }
        return values.toString();
    }

    public static void main(String[] args) {
         String intToStr = int2str(parseFromCommandLine(args));

        System.out.print(String.valueOf(intToStr));

        String result = parseFromCommandLines(args);

        System.out.print(str2int(result));

        System.out.print(rightColumn("COD"));
    }

    public static int str2int(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            result *= 26;
            result += str.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public static String int2str(int columnNumber) {
        
     String columnName = null;

        while (columnNumber > 0) {
            int rem = columnNumber % 26;
            if (rem == 0) {

                columnName = "Z";
                columnNumber = (columnNumber / 26) - 1;
            } else {
                if (columnName != null) {
                    columnName.charAt((char) ((rem - 1) + 'A'));
                }
                columnNumber = columnNumber / 26;
            }
        }

        assert columnName != null;
        char[] array = columnName.toCharArray();
        String result = "";

        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }

    public static String rightColumn(String number) {
        return number;
    }
}
