package com.encryption.app;

public class Validator
{ 
	public static boolean isValidMenuChoice(String menuChoice)
	{
		boolean validSelection = true;
		String[] validEntries = {"1", "2", "3", "4"};
		
		for (int i = 0; i < validEntries.length; i++)
		{	
			if(menuChoice.equalsIgnoreCase(validEntries[i].toString()))
			{
				if(validSelection)
				{
					System.out.println("This is not a valid menu entry.  Please try again");
				}
				
			}
		
	}
		return validSelection;
	}
	
}
	
	
