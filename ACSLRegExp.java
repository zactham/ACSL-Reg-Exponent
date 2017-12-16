//Zac Thamer
//4 11 16
//Period 3
import java.util.Scanner;
public class ACSLRegExp 
{
	static Scanner input = new Scanner(System.in);

	public static void input()
	{
				
		String [] firstInputs = new String [10];
		for (int i = 0; i<10; i ++)
		{
			System.out.print("Input 1: ");
			firstInputs[i] = input.next();//watch out for the first string being #
			//call method using this
		}
		 
		// TEMP
		//String [] firstInputs = {"#", "aac", "acc", "abc", "ac", "abbc", "abbbc", "abbbbc", "aabc", "accb"};


		// replace # with empty string
		// move this to a function
		for (int i = 0; i < 10; i++)
		{
			if (firstInputs[i].equals("#"))
				firstInputs[i] = "";
		}


		System.out.print("Input 2: ");
		String input2 = input.next();
		symbolCheck(input2, firstInputs);

		System.out.print("Input 3: ");
		String input3 = input.next();
		symbolCheck(input3, firstInputs);

		System.out.print("Input 4: ");
		String input4 = input.next();
		symbolCheck(input4, firstInputs);

		System.out.print("Input 5: ");
		String input5 = input.next();
		symbolCheck(input5, firstInputs);

		System.out.print("Input 6: ");
		String input6 = input.next();
		symbolCheck(input6, firstInputs);
	}

	public static void symbolCheck(String inputAll, String [] fI)
	{

		if (containsDot(inputAll))
		{

			for (int i = 0; i < 10; i++)
			{
				int counter1 = 0;
				String str = fI[i];
				if (str.length() == inputAll.length())
				{
					for (int z = 0; z < str.length(); z++)
					{
						if (str.charAt(z) == inputAll.charAt(z) || inputAll.charAt(z) == '.')
						{
							counter1++;
						}
					}
					if (counter1 == str.length())
						System.out.print(str + " ");
					else
						System.out.println("NONE");
				}
			}
			System.out.println();
		}


		else if (containsBrackCarrot(inputAll))
		{
			int brackIndex = 0;
			int endBrackIndex = 0;

			for (int i = 1; i < 10; i++)
			{
				String str = fI[i];//first string in the first input

				brackIndex = inputAll.indexOf("[");
				endBrackIndex = inputAll.indexOf("]");

				// find string inside brackets
				String brackString = inputAll.substring(brackIndex, endBrackIndex+1);

				int inputStringLength = inputAll.length() - (endBrackIndex - brackIndex);
				if (inputStringLength == str.length())
				{

					boolean ok = true;
					int zz = 0;
					for (int z = 0; z < str.length() && zz < inputAll.length(); z++, zz++)
					{
						if (inputAll.charAt(z) == '[')
						{
							if (brackString.contains(Character.toString(str.charAt(z))))
								ok = false;
							zz = endBrackIndex;
						}
						else
						{
							if (str.charAt(z) != inputAll.charAt(zz))
							{
								ok = false;
							}
						}
					}
					if (ok)
						System.out.print(str + " ");
					else
						System.out.print("None");
				}

			}
			System.out.println();
		}

		else if (containsStar(inputAll))//TODO
		{
			for (int i = 1; i < 10; i++)
			{
				String str = fI[i];//first string in the first input

				int starIndex = inputAll.indexOf('*');

				String startString = inputAll.substring(0, starIndex-1);
				Character starChar = inputAll.charAt(starIndex-1);
				String endString = inputAll.substring(starIndex+1, inputAll.length());

				int midStartIndex = starIndex-1;
				int midEndIndex = str.length() - endString.length() - 1;

				boolean ok = true;
				if (!str.startsWith(startString))
					ok = false;
				else
					if (!str.endsWith(endString))
						ok = false;
					else
					{
						for (int z = midStartIndex; z <= midEndIndex; z++)
						{
							if (str.charAt(z) != starChar)
							{
								ok = false;
							}
						}
					}
				if (ok)
					System.out.print(str + " ");
			}
			System.out.println();
		}
		else if (containsCurls(inputAll))//TODO
		{
			for (int i = 1; i < 10; i++)
			{
				String str = fI[i];//first string in the first input

				int starIndex = inputAll.indexOf('{');	// opening bracket index

				int min = Character.getNumericValue(inputAll.charAt(starIndex+1));
				int max = Character.getNumericValue(inputAll.charAt(starIndex+3));

				String startString = inputAll.substring(0, starIndex-1);
				Character starChar = inputAll.charAt(starIndex-1);
				String endString = inputAll.substring(starIndex+5, inputAll.length());

				int midStartIndex = starIndex-1;
				int midEndIndex = str.length() - endString.length() - 1;

				int numCharsInMid = midEndIndex - midStartIndex +1;

				boolean ok = true;
				if (!str.startsWith(startString))
					ok = false;
				else
					if (!str.endsWith(endString))
						ok = false;
					else
					{
						for (int z = midStartIndex; z <= midEndIndex; z++)
						{
							if (str.charAt(z) != starChar)
							{
								ok = false;
							}
						}
					}


				if (ok && numCharsInMid <= max && numCharsInMid >= min)
					System.out.print(str + " ");
			}
			System.out.println();
		}
		else if (containsBrack(inputAll))
		{
			int brackIndex = 0;
			int endBrackIndex = 0;

			for (int i = 1; i < 10; i++)
			{
				String str = fI[i];//first string in the first input

				brackIndex = inputAll.indexOf("[");
				endBrackIndex = inputAll.indexOf("]");
				int inputStringLength = inputAll.length() - (endBrackIndex - brackIndex);
				if (inputStringLength == str.length())
				{
					// find string inside brackets
					String brackString = inputAll.substring(brackIndex, endBrackIndex+1);

					boolean ok = true;
					int zz = 0;
					for (int z = 0; z < str.length() && zz < inputAll.length(); z++, zz++)
					{
						if (inputAll.charAt(z) == '[')
						{
							if (!brackString.contains(Character.toString(str.charAt(z))))
								ok = false;
							zz = endBrackIndex;
						}
						else
						{
							if (str.charAt(z) != inputAll.charAt(zz))
							{
								ok = false;
							}
						}
					}
					if (ok)
						System.out.print(str + " ");
				}
			}
			System.out.println();
		}
	}

	public static boolean containsDot(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (str.substring(i,i+1).equals("."))
			{
				return true;
			}
		}
		return false;
	}

	public static boolean containsBrack(String str)
	{
		boolean check = false;
		for (int i = 0; i < str.length()-1; i++)
		{
			if (str.substring(i,i+1).equals("[") && !str.substring(i,i+2).equals("[^"))
			{
				check = true;
			}
		}
		return check;
	}

	public static boolean containsBrackCarrot(String str)
	{
		boolean check = false;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.substring(i,i+1).equals("^"))
			{
				check = true;
			}
		}
		return check;
	}

	public static boolean containsStar(String str)
	{
		boolean check = false;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.substring(i,i+1).equals("*"))
			{
				check = true;
			}
		}
		return check;
	}

	public static boolean containsCurls(String str)
	{
		boolean check = false;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.substring(i,i+1).equals("{"))
			{
				check = true;
			}
		}
		return check;
	}

	public static void main(String[]args)
	{
		input();
	}
}
