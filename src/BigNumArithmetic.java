import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) {
        if (0 < args.length) {
            try {
                FileInputStream file = new FileInputStream(args[0]);
                Scanner scr = new Scanner(file);
                while(scr.hasNextLine()) {
                    //System.out.println(scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", ""));
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", "");		//replaces extra spaces and lines with 1 space or nothing
                    String[] items = line.split(" ");
                    for (int i = 0; i < items.length; i++) {
                        if (items[i].length() > 0) {
                            System.out.println(items[i]);
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("The file " + args[0] + " was not found!");
            }
        }
    }
}
