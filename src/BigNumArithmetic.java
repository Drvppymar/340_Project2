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
        System.out.print("=");
    }
    
    //Reverse the characters of a given string
    public String reverseString(String a) {
    	char ch;
    	//Initialize an empty string to create reversed string inside
    	String reversedString = "";
    	for (int i = 0; i < a.length(); i++) {
    		//Get character at a certain position
    		ch = a.charAt(i);
    		//Add character to the reversed string
    		reversedString = ch + reversedString;
    	}
    	//Return the reversed string
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

    //Adding and returning the sum of two numbers in the form of a string
    public String mathAddition(String a, String b) {
    	//Reverse the first string
    	String newA = reverseString(a);
    	//Instantiate an empty linked list for the first string
    	LList numA = new LList();
    	//Convert the string to a linked list and set that equal to the empty linked list numA
    	numA = stringToLList(newA);
    	//Reverse the second string
    	String newB = reverseString(b);
    	//Instantiate an empty linked list for the second string
    	LList numB = new LList();
    	//Convert the string to a linked list and set that equal to the empty linked list numB
    	numB = stringToLList(newB);
    	//Get the length of the first linked list
    	int listALength = numA.length();
    	//Get the length of the second linked list
    	int listBLength = numB.length();
    	
    	if(listALength>listBLength) {
    		//Find difference between listA length and listB length
    		int diff = listALength-listBLength;
    		for (int i = 0; i < diff; i++) {
    			//Append 0's to listB until the lists are equal in length
    			numB.append(0);
    		}
    	}
    	else if(listBLength > listALength) {
    		//Find difference between listB length and listA length
    		int diff = listBLength - listALength;
    		for (int i = 0; i < diff; i++) {
    			//Append 0's to listA until the lists are equal in length
    			numA.append(0);
    		}
    	}
    	
    	//Initialize carry value to equal 0
    	int carry = 0;
    	//Initialize a new linked list that holds the sum of listA and listB
    	LList sum = new LList();
    	//Iterate through each value of listA and listB
    	for (int i = 0; i < numA.length(); i++) {
    		//Move current position
    		numA.moveToPos(i);
    		//Convert string at current position to an integer
    		int n = Integer.parseInt(numA.getValue().toString());
    		//Move current position
    		numB.moveToPos(i);
    		//Convert string at current position to an integer
    		int m = Integer.parseInt(numB.getValue().toString());
    		//Add integer n and m with carry value
    		int sumValue = carry + n + m;
    		//If carry was added to previous sum value
    		if (carry == 1) {
    			//Subtract so carry=0
    			carry--;
            }
    		//If sum of n, m, and carry is greater than or equal to 10
    		if (sumValue>=10) {
    			//Add carry value for next operation
    			carry++;
    			//Add sumValue-10 to sum linked list
                sum.append(sumValue-10);
            } else {
            	//Add sumValue to sum linked list
                sum.append(sumValue);
            }
    	}
    	
    	//If at end of list and carry != 0
    	if(carry != 0) {
    		//Add a new node to sum linked list with value 1
    		sum.append(1);
    	}
    	//Convert sum linked list to a string and reverse it
    	String finalSum = reverseString(llistToString(sum));
    	//Return the sum of numA and numB in the form of a string
    	return finalSum;
    }

    //Function to see which number is bigger if two numbers have the same length
    public boolean greaterThan(String a, String b) {
    	//Loop through strings a and b
        for (int i = 0; i < a.length(); i++) {
        	//Store the value of a in c
            String c = String.valueOf(a.charAt(i));
            //Store the value of b in d
            String d = String.valueOf(b.charAt(i));
            //If the integer c is greater than the integer d
            if (Integer.parseInt(c) > Integer.parseInt(d)) {
                return true;
            //If the integer d is greater than the integer c
            } else if (Integer.parseInt(d) > Integer.parseInt(c)) {
                return false;
            }
        }
        return false;
    }
    
    public String mathSubtraction(String a, String b) {
    	//Reverse the first string
    	String newA = reverseString(a);
    	//Instantiate an empty linked list for the first string
    	LList numA = new LList();
    	//Convert the string to a linked list and set that equal to the empty linked list numA
    	numA = stringToLList(newA);
    	//Reverse the second string
    	String newB = reverseString(b);
    	//Instantiate an empty linked list for the second string
    	LList numB = new LList();
    	//Convert the string to a linked list and set that equal to the empty linked list numB
    	numB = stringToLList(newB);
    	//Get the length of the first linked list
    	int listALength = numA.length();
    	//Get the length of the second linked list
    	int listBLength = numB.length();
    	
    	//Initialize carry value to equal 0
    	int carry = 0;
    	//Initialize a new linked list that holds the difference of a and b
		LList sum = new LList();
    	if(listALength > listBLength) {
    		//Find difference of the lengths of a and b
    		int diff = listALength - listBLength;
    		for(int i =0; i < diff; i++) {
    			//Append 0's until a length = b length
    			numB.append(0);
    		}
    		//Loop through both a and b
    		for(int i = 0; i < listALength; i++) {
    			//Move current position of a
    			numA.moveToPos(i);
    			//Convert string a at current position to an integer
    			int n = Integer.parseInt(numA.getValue().toString());
    			//Move current position of b
    			numB.moveToPos(i);
    			//Convert string b at current position to an integer
    			int m = Integer.parseInt(numB.getValue().toString());
    			//Add integer n with carry value and subtract sum by m
    			int sumValue = (carry + n) - m;
    			//If carry was added to previous sum value
    			if(carry == -1) {
    				//Make carry value equal 0
    				carry++;
    			}
    			//If sum is negative
    			if(sumValue < 0) {
    				//Subtract from carry value
    				carry--;
    				//Add 10 to sum
    				sumValue = sumValue + 10;
    			}
    			sum.append(sumValue);
    		}
    	} else if(listBLength > listALength) {
    		//Find difference of the lengths of b and a
    		int diff = listBLength - listALength;
    		for(int i =0; i < diff; i++) {
    			//Append 0's until a length = b length
                numA.append(0);
            }
    		//Loop through both a and b
    		for(int i = 0; i < listBLength; i++) {
    			//Move current position of a
    			numA.moveToPos(i);
    			//Convert string a at current position to an integer
    			int n = Integer.parseInt(numA.getValue().toString());
    			//Move current position of b
    			numB.moveToPos(i);
    			//Convert string b at current position to an integer
    			int m = Integer.parseInt(numB.getValue().toString());
    			//Add integer m with carry value and subtract by n
    			int sumValue = (carry + m) - n;
    			//If carry was added to previous sum value
    			if(carry == -1) {
    				//Make carry value equal 0
    				carry++;
    			}
    			//If carry value is negative
    			if(sumValue < 0) {
    				//Subtract from carry value
    				carry--;
    				//Add 10 to sum
    				sumValue = sumValue + 10;
    			}
    			sum.append(sumValue);
    		}
    	//If values a and b are the same length, and a is greater than b
    	} else if (greaterThan(a, b) == true) {
    		//Loop through both a and b
            for(int i = 0; i < listALength; i++) {
            	//Move current position of a
                numA.moveToPos(i);
                //Convert string a at current position to an integer
                int n = Integer.parseInt(numA.getValue().toString());
                //Move current position of b
                numB.moveToPos(i);
                //Convert string b at current position to an integer
                int m = Integer.parseInt(numB.getValue().toString());
                //Add integer n with carry value and subtract sum by m
                int sumValue = (carry + n) - m;
                //If carry value was added to previous sum value
                if(carry == -1) {
                	//Make carry equal 0 again
                    carry++;
                }
                //If carry value is negative
                if(sumValue < 0) {
                	//Subtract from carry value
                    carry--;
                    //Add 10 to sum
                    sumValue = sumValue + 10;
                }
                sum.append(sumValue);
            }
        //If values a and b are the same length, and b is greater than a
        } else if (greaterThan(a, b) != true) {
        	//Loop through both a and b
            for(int i = 0; i < listBLength; i++) {
            	//Move current position of a
                numA.moveToPos(i);
                //Convert string a at current position to an integer
                int n = Integer.parseInt(numA.getValue().toString());
                //Move current position of b
                numB.moveToPos(i);
                //Convert string b at current position to an integer
                int m = Integer.parseInt(numB.getValue().toString());
                //Add integer m with carry value and subtract sum by n
                int sumValue = (carry + m) - n;
                //If carry value was added to previous sum value
                if(carry == -1) {
                	//Make carry equal 0 again
                    carry++;
                }
                //If carry value is negative
                if(sumValue < 0) {
                	//Subtract from carry value
                    carry--;
                    //Add 10 to sum
                    sumValue = sumValue + 10;
                }
                sum.append(sumValue);
            }
        }
    	//Convert sum llist to string
        String finalSum = reverseString(llistToString(sum)).replaceAll("^0+(?!$)", "");
        //Returns the sum in the form of a string
        return finalSum;
    }

    public String mathMultiplication(String a, String b) {
        //Convert both input strings into reverse
        String numA = reverseString(a);
        String numB = reverseString(b);
        //Convert both reversed strings into linked lists
        LList listA = stringToLList(numA);
        LList listB = stringToLList(numB);
        //Get the length of both linked lists
        int aLength = listA.length();
        int bLength = listB.length();
        //Create a stack object
        LStack l = new LStack();
        //Create a solution linked list to store solution of one digit multiplied by another number
        LList solution = new LList();
        //Initialize sum variable which we will return when done
        String sum = "";
        //Initialize carry variable
        int carry = 0;
        //Check to see if first string is bigger then the second
        if (aLength > bLength) {
            //If so we enter a nested for loop, looping through bigger number while multiplying it by the individual digit in smaller number
            for (int i = 0; i < bLength; i++) {
                //Move to position in smaller number
                listB.moveToPos(i);
                if (i > 0) {
                    //If we ever shift to another digit in smaller number, we have to add zeros the solution linked list as we are shifting
                    for (int c = 0; c < i; c++) {
                        solution.append(0);
                    }
                }
                //Looping through every digit in larger number while we stay at one digit in smaller number until we reach the end
                for (int j = 0; j < aLength; j++) {
                    //Move to position in larger number
                    listA.moveToPos(j);
                    //Get the int value from both numbers at the positions
                    int n = Integer.parseInt(listA.getValue().toString());
                    int m = Integer.parseInt(listB.getValue().toString());
                    //Value equals both digits multiplied + if we have a carry, will be 0 if we don't
                    int value = n * m + carry;
                    if (value >= 10) {
                        //If the value is ever greater than or equal to 10, the carry equals the value divided by 10
                        carry = value / 10;
                        //Then the value to be appended to the linked list is value modulo 10
                        solution.append(value % 10);
                    } else {
                        //If the value is not greater than or equal to 10 then we just append the value and make sure carry is 0
                        solution.append(value);
                        carry = 0;
                    }
                }
                //If at the end of the bigger number there is still a carry, append the carry and then make it 0
                if (carry != 0) {
                    solution.append(carry);
                    carry = 0;
                }
                //Lastly, we can push the solution onto the stack, not in reverse, so all the products can be added together later
                String sol = reverseString(llistToString(solution));
                l.push(sol);
                //Clear solution linked list so we can move to next digit
                solution.clear();
            }
        //Does the same exact thing as the nested for loop above, just for if the b string is larger or if they have the same length.
        } else {
            for (int i = 0; i < aLength; i++) {
                listA.moveToPos(i);
                if (i > 0) {
                    for (int c = 0; c < i; c++) {
                        solution.append(0);
                    }
                }
                for (int j = 0; j < bLength; j++) {
                    listB.moveToPos(j);
                    int n = Integer.parseInt(listA.getValue().toString());
                    int m = Integer.parseInt(listB.getValue().toString());
                    int value = n * m + carry;
                    if (value >= 10) {
                        carry = value / 10;
                        solution.append(value % 10);
                    } else {
                        solution.append(value);
                        carry = 0;
                    }
                }
                if (carry != 0) {
                    solution.append(carry);
                    carry = 0;
                }
                String sol = reverseString(llistToString(solution));
                l.push(sol);
                solution.clear();
            }
        }
        //Now, while the stack has more than one product on it, we add all of them up, popping two at a time and pushing the sum of the mathAddition function onto the stack
        while (l.length() > 1) {
            l.push(mathAddition(l.pop().toString(), l.pop().toString()));
        }
        //Lastly, the answer will be the only number left on the stack, so we pop it and save it to the sum variable
        sum = l.pop().toString();
        //Return the answer
        return sum;
    }

    //Function to have rules for popping and pushing on stack
    public String stackRule(String[] line) {
        //Create LStack object
        LStack l = new LStack();
        //Loop through line array
        for (int i = 0; i < line.length; i++) {
            //Check if the item we see is not the + or - operator
            if(line[i].equals("+") != true && line[i].equals("-") != true && line[i].equals("*") != true) {
                //If not, we push the item onto the stack as it is a number
                l.push(line[i]);
            } else if (line[i].equals("+") == true && l.length() >= 2) { //Else, check if it is the + operator and that there is at least two numbers to pop off the stack
                //Pop two numbers off the stack and save them into variables
                String one = l.pop().toString();
                String two = l.pop().toString();
                //Passed them into the mathAddition function and push the result onto the stack
                l.push(mathAddition(two, one));
            }
            //Else, check if it is the - operator and that there is at least two numbers to pop off the stack
            else if (line[i].equals("-") == true && l.length() >= 2) {
            	String one = l.pop().toString();
            	String two = l.pop().toString();
                //Passed them into the mathSubtraction function and push the result onto the stack
            	l.push(mathSubtraction(two, one));
                //Else, check if it is the * operator and that there is at least two numbers to pop off the stack
            } else if (line[i].equals("*") == true && l.length() >= 2) {
                String one = l.pop().toString();
                String two = l.pop().toString();
                //Passed them into the mathMultiplication function and push the result onto the stack
                l.push(mathMultiplication(two, one));
            } else {
                return null;
            }
        }
        //If there isn't exactly one number left at the end of the conditions, then invalid expression return nothing
        if (l.length() > 1 || l.length() < 1) {
            return null;
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
                        String solution = " ";
                        if (b.stackRule(items) != null) {
                            solution = solution + b.stackRule(items).replaceAll("^0+(?!$)", "");
                            System.out.println(solution);
                        } else {
                            System.out.print("\n");
                        }
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
