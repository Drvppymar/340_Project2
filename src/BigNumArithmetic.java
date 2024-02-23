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
    	
        //convert each reverse string to linked list
    	String newA = reverseString(a);
    	LList num1 = new LList();
    	num1 = stringToLList(newA);
    	String newB = reverseString(b);
    	LList num2 = new LList();
    	num2 = stringToLList(newB);
    	int listALength = num1.length();
    	int listBLength = num2.length();
    	
    	//find difference between length of each linked list, add zeroes to front of list where needed
    	if(listALength>listBLength) {
    		int diff = listALength-listBLength;
    		for(int i = 0; i < diff;i++) {
    			num2.moveToStart();
    			num2.insert(0);
    		}
    	}
    	else if(listBLength>listALength) {
    		int diff = listBLength-listALength;
    		for(int i = 0; i<diff; i++) {
    			num1.moveToStart();
    			num1.insert(0);
    		}
    	}
    	
    	//initialize carry to equal 0
    	int carry = 0;
    	LList sum = new LList();
    	for (int i = 0; i<listALength; i++) {
    		num1.moveToPos(i);
    		num1.getValue();
    		num2.moveToPos(i);
    		num2.getValue();
    		//add num1, num2, carry
    		//append sums at each position
    	}
    	if(carry != 0) {
    		sum.append(1);
    	}
    	//add position[i] from each linked list + carry
    	//if at end of list and carry != 0, make a new node with value 1
    	return a;	//stub
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
