import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) {
        if (0 < args.length) {
            try {
                FileInputStream file = new FileInputStream(args[0]);
                Scanner scr = new Scanner(file);
                while(scr.hasNextLine()) {
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", "");
                    String[] items = line.split(" ");
                    if (line.length() > 0) {
                        System.out.println(line);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("The file " + args[0] + " was not found!");
            }
        }
    }
}
