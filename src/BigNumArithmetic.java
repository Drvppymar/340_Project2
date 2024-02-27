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
        System.out.print("= ");
    }
    
    //reverse the characters of a given string
    public String reverseString(String a) {
    	char ch;
    	String reversedString = "";					//initialize an empty string to create reversed string inside
    	for(int i = 0; i < a.length(); i++) {
    		ch = a.charAt(i);						//get character at a certain position
    		reversedString = ch + reversedString;	// add character to the reversed string
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
        while (l.isAtEnd() != true) {
            a = a + l.getValue();
            l.next();
        }
        return a;
    }

    //adding and returning the sum of two numbers in the form of a string
    public String mathAddition(String a, String b) {
    	String newA = reverseString(a);				//reverse the first string
    	LList numA = new LList();					//instantiate an empty linked list for the first string
    	numA = stringToLList(newA);					//convert the string to a linked list and set that equal to the empty linked list numA
    	String newB = reverseString(b);				//reverse the second string
    	LList numB = new LList();					//instantiate an empty linked list for the second string
    	numB = stringToLList(newB);					//convert the string to a linked list and set that equal to the empty linked list numB
    	int listALength = numA.length();			//get the length of the first linked list
    	int listBLength = numB.length();			//get the length of the second linked list
    	
    	if(listALength>listBLength) {				
    		int diff = listALength-listBLength;		//find difference between listA length and listB length
    		for(int i = 0; i < diff; i++) {			//append 0's to listB until the lists are equal in length
    			numB.append(0);
    		}
    	}
    	else if(listBLength > listALength) {
    		int diff = listBLength - listALength;	//find difference between listB length and listA length
    		for(int i = 0; i < diff; i++) {			//append 0's to listA until the lists are equal in length
    			numA.append(0);
    		}
    	}
    	
    	int carry = 0;								//initialize carry value to equal 0
    	LList sum = new LList();					//initialize a new linked list that holds the sum of listA and listB
    	for (int i = 0; i < listALength; i++) {		//iterate through each value of lisA and listB
    		numA.moveToPos(i);						//move current position
    		int n = Integer.parseInt(numA.getValue().toString());		//convert string at current position to an integer
    		numB.moveToPos(i);						//move current position
    		int m = Integer.parseInt(numB.getValue().toString());		//convert string at current position to an integer
    		int sumValue = carry + n + m;			//add integer n and m with carry value
            if (carry == 1) {						//if carry was added to previous sum value
                carry--;							//subtract so carry=0
            }
    		if (sumValue>=10) {						//if sum of n, m, and carry is greater than or equal to 10
                carry++;							//add carry value for next operation
                sum.append(sumValue-10);			//add sumValue-10 to sum linked list
            } else {
                sum.append(sumValue);				//add sumValue to sum linked list
            }
    	}
    	
    	if(carry != 0) {							//if at end of list and carry != 0
    		sum.append(1);							//add a new node to sum linked list with value 1
    	}
    	String finalSum = reverseString(llistToString(sum));			//convert sum linked list to a string and reverse it
    	return finalSum;							//return the sum of numA and numB in the form of a string
    }

    public String stackRule(String[] line) {
        LStack l = new LStack();
        for (int i = 0; i < line.length; i++) {
            if(line[i].equals("+") != true) {
                l.push(line[i]);
            } else if (line[i].equals("+") == true && l.length() >= 2) {
                String one = l.pop().toString();
                String two = l.pop().toString();
                l.push(mathAddition(two, one));
            }
        }
        if (l.length() > 1 || l.length() < 1) {
            return "";
        }
        return l.pop().toString();
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
                        String solution = b.stackRule(items);
                        System.out.println(solution);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("The file " + args[0] + " was not found!");
            }
        }
    }
}
