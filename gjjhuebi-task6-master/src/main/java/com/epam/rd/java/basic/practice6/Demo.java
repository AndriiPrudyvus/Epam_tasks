package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

    private static final String INPUT = "--input";
    private static final String FILE = "part6.txt";

	public static void main(String[] args) {
	    Part1.main(args);

        Part2.main(args);

        Part3.main(args);

        Part4.main(args);

        Part5.main(args);

        System.out.println("~~~~~~~~~~~~Part6");

        Part6.main(new String[]{INPUT, FILE, INPUT, "frequency"});

        Part6.main(new String[]{INPUT, FILE, INPUT, "length"});

        Part6.main(new String[]{INPUT, FILE, INPUT, "duplicates"});
	}
}
