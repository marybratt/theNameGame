package theNameGame;

import java.util.Scanner;

public class theNameGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// open scanner and then ask name to receive input
		System.out.println("What is your name? I can make it ryhme! ");
		String name = input.nextLine();
		// output string and then call the method to form the rhyme string per instructions
		System.out.println("My rhyme for you is: ");
		System.out.println(getRhyme(name));
		input.close();
	}
	public static String getRhyme(String name) {
		// determine if the last char is a '!' if so remove it otherwise use full name
		char lastChar = name.charAt(name.length()-1);
		// get the first character of name to be able determine the rule to use for the rhyme
		char firstChar = name.charAt(0);
		int firstVowel = findFirstVowel(name);
		// clear variables
		String nameMinusLastChar = "";
		String nameMinusFirstChar = "";
		if (lastChar == '!') {
			// get the name minus the last character which would be the '!'
			nameMinusLastChar = name.substring(0, name.length() - 1);
			// get the name minus the first character  and the last char (!) to be used in the rhyme
			nameMinusFirstChar = name.substring(firstVowel, name.length()-1);
		} else {
			//use the full name - no ! found
			nameMinusLastChar = name;
			// remove the first char of name only - no ! found
			nameMinusFirstChar = name.substring(firstVowel);
			// add the '!' to the name for the last part of the rhyme printout
			name = name + "!";
		}
		
		
		
		String rhyme = ""; // set the string to clear it
		// use first char to determine the exact way to output rhyme, must check both capital and small characters
		switch (firstChar) {
		case 'B':
		case 'b':
			rhyme = nameMinusLastChar + ", " + nameMinusLastChar + 
			" bo-" + nameMinusFirstChar +", Banana fanna fo F" +nameMinusFirstChar +
			", Fee fi mo M" + nameMinusFirstChar + ", " + name;
			break;
		case 'F':
		case 'f':
			rhyme = nameMinusLastChar + ", " + nameMinusLastChar + 
			" bo B" + nameMinusFirstChar +", Banana fanna fo-" +nameMinusFirstChar +
			", Fee fi mo M" + nameMinusFirstChar + ", " + name;
			break;
		case 'M':
		case 'm':
			rhyme = nameMinusLastChar + ", " + nameMinusLastChar + 
			" bo B" + nameMinusFirstChar +", Banana fanna fo F" +nameMinusFirstChar +
			", Fee fi mo-" + nameMinusFirstChar + ", " + name;
			break;
		case 'A':
		case 'a':
		case 'E':
		case 'e':
		case 'I':
		case 'i':
		case 'O':
		case 'o':
		case 'U':
		case 'u':
			//if first char is a vowel need to make sure that name is all lower case
			// so that when add the B, F, or M we will ot have 2 upper case letters in rhyme name
			String nameMinusLastCharSmall = nameMinusLastChar.toLowerCase(); 
			rhyme = nameMinusLastChar + ", " + nameMinusLastChar + 
			" bo B" + nameMinusLastCharSmall +", Banana fanna fo F" +nameMinusLastCharSmall +
			", Fee fi mo M" + nameMinusLastCharSmall + ", " + name;
			break;
		default:
			rhyme = nameMinusLastChar + ", " + nameMinusLastChar + 
				" bo B" + nameMinusFirstChar +", Banana fanna fo F" +nameMinusFirstChar +
				", Fee fi mo M" + nameMinusFirstChar + ", " + name;
			break;
		}
		return rhyme;
	}
	
	/*
	 * This method will check and find the position of the first vowel - if the name begins with multiple consonants 
	 * then we want the rhymes to use the first vowel as the starting point
	 */
	public static int findFirstVowel(String name) {
		char ch = name.charAt(0);
		int firstVowel = 0;
		for (int i = 1 ; i < name.length(); i++) {
			// check if character is a vowel
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch== 'o' || ch=='u' || ch == 'A' || ch == 'E' || ch == 'I' ||ch == 'O' || ch == 'U') {
				firstVowel = i - 1; // i will always be 1 larger than the char tested so need to subtract 1 to get the correct position
				break;
			} else {
				ch = name.charAt(i);
			}
		}
		return firstVowel;
	}
}
# theNameGame
