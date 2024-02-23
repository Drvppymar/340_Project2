import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {

    public String[] lineToArray(String line) {
        String[] lineArray = line.split(" ");
        for (int i = 0; i < lineArray.length; i++) {
            lineArray[i] = lineArray[i].replaceAll("^0+(?!$)", "");
        }
        return lineArray;
    }

    public void arrayToString(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("=\n");
    }
    //insert/append in reverse order instead of additional function
    public String reverseString(String a) {
    	char ch;
    	String reversedString = "";
    	for(int i = 0; i < a.length(); i++) {
    		ch = a.charAt(i);
    		reversedString = ch + reversedString;
    	}
        return reversedString;
    }

    public LList stringToLList(String num) {
        LList l = new LList();
        for (int i = 0; i < num.length(); i++) {
            l.append(num.charAt(i));
        }
        return l;
    }

    public String llistToString(LList l) {
        String a = "";
        //while ()
        return a;
    }

    public String mathAddition(String a, String b) {
        String c = "";
        return c;
    }

	public static void main(String[] args) {
        if (0 < args.length) {
            try {
                FileInputStream file = new FileInputStream(args[0]);
                Scanner scr = new Scanner(file);
                while(scr.hasNextLine()) {
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", "");		//replaces extra spaces and lines with 1 space or nothing
                    BigNumArithmetic b = new BigNumArithmetic();
                    String[] items = b.lineToArray(line);
                    if (line.length() > 0) {
                        b.arrayToString(items);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("The file " + args[0] + " was not found!");
            }
        }
    }
}
