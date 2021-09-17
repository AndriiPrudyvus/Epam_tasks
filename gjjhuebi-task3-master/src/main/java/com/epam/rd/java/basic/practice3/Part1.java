package com.epam.rd.java.basic.practice3;

public class Part1 {

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");

        System.out.print(convert1(input));

        System.out.print(convert2(input));

        System.out.print(convert3(input));

        System.out.print(convert4(input));
    }

    public static String convert1(String input) {
        final String[] lines = input.split("\n");

        final StringBuilder outPutResult = new StringBuilder();

        for (int i = 1; i < lines.length; i++) {

            final String[] fields = lines[i].split("[;]");

            outPutResult.append(fields[0]).append(": ").append(fields[2]).append("\n");
        }
        return outPutResult.toString();
    }

    public static String convert2(String input) {
        final String[] lines = input.split("\n");

        final StringBuilder outPutResult = new StringBuilder();

        for (int i = 1; i < lines.length; i++) {

            final String[] fields = lines[i].split("[;]");

            final String[] name = fields[1].split("[\\s]");

            StringBuilder nameField = new StringBuilder().append(name[1].concat(" ")).append(name[0]);

            outPutResult.append(nameField).append(" (email: ".concat(fields[2])).append(")\n");
        }
        return outPutResult.toString();
    }

    public static String convert3(String input) {
        final String[] lines = input.split("\n");

        boolean google = true;

        boolean mail = true;

        StringBuilder findNameGoogle = new StringBuilder();

        StringBuilder findNameMail = new StringBuilder();

        for (int i = 1; i < lines.length; i++) {

            final String[] names = lines[i].split("[;]");

            final String[] emails = names[2].split("[@]");

            if (emails[1].equals("google.com")) {

                if (google) {
                    findNameGoogle.append(emails[1].concat(" ==> "));
                    google = false;
                }
                findNameGoogle.append(names[0]).append(", ");
            }

            if (emails[1].equals("mail.com")) {
                if (mail) {
                    findNameMail.append(emails[1].concat(" ==> "));
                    mail = false;
                }
                findNameMail.append(names[0]).append(", ");
            }
        }

        findNameMail.setLength(findNameMail.length() - 2);

        findNameGoogle.setLength(findNameGoogle.length() - 2);

        return findNameMail.append("\n").append(findNameGoogle).append("\n").toString();
    }

    public static String convert4(String input) {
        final String[] lines = input.split("\n");

        StringBuilder outPutResult = new StringBuilder();

        int[] randomNumber = {1707, 9321, 4623, 7514};

        for (int i = 0; i < lines.length; i++) {

            final String[] line = lines[i].split("[;]");

            if (i == 0) {

                outPutResult.append(line[0].concat(";")).
                        append(line[1].concat(";")).
                        append(line[2].concat(";")).
                        append("Password\n");
            } else {

                outPutResult.append(line[0].concat(";")).
                        append(line[1].concat(";")).
                        append(line[2].concat(";")).
                        append((randomNumber[i - 1])).
                        append("\n");
            }
        }
        return outPutResult.toString();
    }
}