//Zac Thamer
//4 15 16
//Period 3
import java.util.Scanner;
import java.util.regex.Pattern;
public class ACSLRegExpSenior 
{
	static Scanner input = new Scanner(System.in);

	public static void tester(String [] array)
	{
		System.out.print("Input: ");
		String pattern = input.next();
		Pattern p = Pattern.compile(pattern);
		for (int i = 0; i < 10; i++)
		{
			if (p.matcher(array[i]).matches())
			{
				System.out.println(array[i]);
			}  
		}
	}

	public static void main(String[]args)
	{
		
		String [] firstInputs = new String [10];
		
		for (int i = 0; i<10; i ++)
		{
			System.out.print("Input 1: ");
			firstInputs[i] = input.next();//watch out for the first string being #
			//call method using this
		}
		

		// Test Data
		//String [] firstInputs = {"#", "aac", "acc", "abc", "ac", "abbc", "abbbc", "abbbbc", "aabc", "aabbc"};


		for (int i = 0; i < 10; i++)
		{
			if (firstInputs[i].equals("#"))
				firstInputs[i] = "";
		}

		for (int i = 0; i <5; i++)
			tester(firstInputs);
	}
}