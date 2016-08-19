package com.encryption.app;

import java.util.Scanner;

public class Adventure

{
	static boolean retry = true;

	public static void main(String[] args)
	{

		String userInput = null;
		
			do
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Welcome to the Encryptor!");
				System.out.println("Enter a message to encrypt:");
				userInput = sc.nextLine();
				String theMessageToBeCoded = userInput;
				System.out.println();


				if (theMessageToBeCoded.matches("[a-z A-Z]+$")) 
				 {
				System.out.println(Adventure.encrypt(theMessageToBeCoded, 6));
				System.out.println(Adventure.decrypt(Adventure.encrypt(theMessageToBeCoded, 6), 6) + "\n");
				}
				else
				{
							System.out.println("Numbers are not valid. Please type only letters.");
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

}//class
