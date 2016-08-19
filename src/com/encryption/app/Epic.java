package com.encryption.app;

import java.util.Scanner;


public class Epic
{

	static boolean retry = true;

	public static void main(String[] args)
	{
		
		String menuChoice = null;
		String userInput = null;
		String userMessage = null;
		String theMessageToBeCoded = userInput;
		int userShift = 0;
		int randomShift = 0;
		
		do
		{
				Scanner shiftNumber = new Scanner(System.in);
				Scanner sc = new Scanner(System.in);
				System.out.println("Welcome to the Encryptor!");
				System.out.println("Please select 1, 2, 3, or 4 to continue:" +"\n\t 1) Encrypt message with a shift of 6"
						+ "\n\t 2) Encrypt message with your choice of shift" +  "\n\t 3) Encrypt message with random shift" + "\n\t 4) Exit" );
				menuChoice = sc.nextLine();
				System.out.println();
	
				switch (menuChoice)
				{
				case "1":
					System.out.println("Enter a message to encrypt:");
					userInput = sc.nextLine();
					theMessageToBeCoded = userInput;
					encrypt(theMessageToBeCoded, 6);
					System.out.println(encrypt(theMessageToBeCoded, 6));
					System.out.println();
					
					break;

				case "2":
					System.out.println("Enter a message to encrypt:");
					userInput = sc.nextLine();
					theMessageToBeCoded = userInput;
					System.out.println("Enter the number of shifts:");
					userShift = shiftNumber.nextInt();
					encrypt(theMessageToBeCoded, userShift);
					System.out.println(encrypt(theMessageToBeCoded, userShift));
					System.out.println();
					break;

				case "3":	
					randomShift = (int)(Math.random()*26) +1;
					System.out.println("Enter a message to encrypt:");
					userInput= sc.nextLine();
					theMessageToBeCoded = userInput;
					encrypt(theMessageToBeCoded, randomShift);
					System.out.println(encrypt(theMessageToBeCoded, randomShift));
					System.out.println();
					break;
					
				case "4":
					System.out.println("Goodbye!");
					System.exit(0);
					break;
				}
		
				
		} while (retry);
		
	}// main

	public static String decrypt(String encode, int offset)
	{
		return encrypt(encode, 26 - offset);
	}

	public static String encrypt(String encode, int shift)
	{
		shift = shift % 26 + 26;
		StringBuilder encrypted = new StringBuilder();
		for (char i : encode.toCharArray())
		{
			if (Character.isLetter(i))
			{
				if (Character.isUpperCase(i))
				{
					encrypted.append((char) ('A' + (i - 'A' + shift) % 26));
				} else
				{
					encrypted.append((char) ('a' + (i - 'a' + shift) % 26));
				}
			} else
			{
				encrypted.append(i);
			}
		}
		return encrypted.toString().toUpperCase();
	}

}
