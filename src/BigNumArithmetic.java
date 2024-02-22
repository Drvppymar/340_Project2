import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {
    removeLeadingZeroes
	
	public static void main(String[] args) {
        if (0 < args.length) {
            try {
                FileInputStream file = new FileInputStream(args[0]);
                Scanner scr = new Scanner(file);
                while(scr.hasNextLine()) {
<<<<<<< HEAD
                    //System.out.println(scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", ""));
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", "");		//replaces extra spaces and lines with 1 space or nothing
=======
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", "");
>>>>>>> branch 'master' of https://github.com/Drvppymar/340_Project2.git
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
