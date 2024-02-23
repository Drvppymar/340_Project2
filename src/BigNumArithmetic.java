import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {

    public static String[] lineToArray(String line) {
        String[] lineArray = line.split(" ");
        for (int i = 0; i < lineArray.length; i++) {
            lineArray[i] = lineArray[i].replaceAll("^0+(?!$)", "");
        }
        return lineArray;
    }

    public static void arrayToString(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("=\n");
    }
    
    //insert/append in reverse order instead of additional function
    public static void reverseString(String line) {
    	char ch;
    	String reversedString;
    	for(int i=0;i<str.length();i++) {
    		ch = line.charAt(i);
    		reversedString = ch+reversedString;
    	}
    }

    /*
    public static LList stringToLList(String num) {
        LList l = new LList();
        for (int i = 0; i < num.length(); i++) {
            l.append(num.charAt(i));
        }
        return l;
    }
     */

	public static void main(String[] args) {
        if (0 < args.length) {
            try {
                FileInputStream file = new FileInputStream(args[0]);
                Scanner scr = new Scanner(file);
                while(scr.hasNextLine()) {
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", "");		//replaces extra spaces and lines with 1 space or nothing
                    String[] items = lineToArray(line);
                    if (line.length() > 0) {
                        arrayToString(items);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("The file " + args[0] + " was not found!");
            }
        }
    }
}
