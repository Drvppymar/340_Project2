import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {

    //Function to convert the line itself to an array with each operand and operator as an item.
    public String[] lineToArray(String line) {
        //Split the line at every space and put the items into the array.
        String[] lineArray = line.split(" ");
        //Loop through the array
        for (int i = 0; i < lineArray.length; i++) {
            //Get rid of leading zeroes of every string in the array.
            lineArray[i] = lineArray[i].replaceAll("^0+(?!$)", "");
        }
        return lineArray;
    }

    //Function to convert the array to a string to print out operations in a line.
    public void arrayToString(String[] a) {
        //Loop through array with operands and operators
        for (int i = 0; i < a.length; i++) {
            //Print each item with a space in between
            System.out.print(a[i] + " ");
        }
        //Print out equal sign at end on same line.
        System.out.print("= ");
    }
    
    //reverse the characters of a given string
    public String reverseString(String a) {
    	char ch;
    	String reversedString = "";					//initialize an empty string to create reversed string inside
    	for (int i = 0; i < a.length(); i++) {
    		ch = a.charAt(i);						//get character at a certain position
    		reversedString = ch + reversedString;	//add character to the reversed string
    	}
        return reversedString;
    }

    //Function to convert a string to a linked list.
    public LList stringToLList(String num) {
        //Create a linked list
        LList l = new LList();
        //Loop through characters in string
        for (int i = 0; i < num.length(); i++) {
            //Append them to the linked list
            l.append(num.charAt(i));
        }
        //Return linked list
        return l;
    }

    //Function to convert a linked list to a string.
    public String llistToString(LList l) {
        //Create a string variable
        String a = "";
        //While we are not at the end of the linked list
        while (l.isAtEnd() != true) {
            //Add the character to the string
            a = a + l.getValue();
            //Move to next node in linked list
            l.next();
        }
        //Return the string
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
    		for (int i = 0; i < diff; i++) {			//append 0's to listB until the lists are equal in length
    			numB.append(0);
    		}
    	}
    	else if(listBLength > listALength) {
    		int diff = listBLength - listALength;	//find difference between listB length and listA length
    		for (int i = 0; i < diff; i++) {			//append 0's to listA until the lists are equal in length
    			numA.append(0);
    		}
    	}
    	
    	int carry = 0;								//initialize carry value to equal 0
    	LList sum = new LList();					//initialize a new linked list that holds the sum of listA and listB
    	for (int i = 0; i < numA.length(); i++) {		//iterate through each value of lisA and listB
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

    //Function to have rules for popping and pushing on stack
    public String stackRule(String[] line) {
        //Create LStack object
        LStack l = new LStack();
        //Loop through line array
        for (int i = 0; i < line.length; i++) {
            //Check if the item we see is not the + operator
            if(line[i].equals("+") != true) {
                //If not, we push the item onto the stack as it is a number
                l.push(line[i]);
            } else if (line[i].equals("+") == true && l.length() >= 2) { //Else, check if it is the + operator and that there is at least two numbers to pop off the stack
                //Pop two numbers off the stack and save them into variables
                String one = l.pop().toString();
                String two = l.pop().toString();
                //Passed them into the mathAddition function and push the result onto the stack
                l.push(mathAddition(two, one));
            }
        }
        //If there isn't exactly one number left at the end of the conditions, then invalid expression return nothing
        if (l.length() > 1 || l.length() < 1) {
            return "";
        }
        //Else return the solution of the expression.
        return l.pop().toString();
    }

	public static void main(String[] args) {
        //Make sure an argument is passed in
        if (0 < args.length) {
            try {
                //Try to create a file input stream and scanner
                FileInputStream file = new FileInputStream(args[0]);
                Scanner scr = new Scanner(file);
                //While the file that was passed has a next line
                while(scr.hasNextLine()) {
                    //Save the line without all the leading spaces and spaces in between into a string variable
                    String line = scr.nextLine().replaceAll("\\s+", " ").replaceAll("^\\s+", ""); //replaces extra spaces and lines with 1 space or nothing
                    //Create a BigNumArithmetic object
                    BigNumArithmetic b = new BigNumArithmetic();
                    //Create a string array from the line after passing it into the lineToArray function
                    String[] items = b.lineToArray(line);
                    //Check to make sure the line has something in it (Skip blank lines)
                    if (line.length() > 0) {
                        //Prints the line without extra spaces, leading zeroes and an equal sign
                        b.arrayToString(items);
                        //Get the solution of the line expression by saving the stackRule return into a string
                        String solution = b.stackRule(items);
                        // Print out the solution onto the same line
                        System.out.println(solution);
                    }
                }
            //Catch file not found exception
            } catch (FileNotFoundException e) {
                //Print out error
                System.out.println("The file " + args[0] + " was not found!");
            }
        }
    }
}
