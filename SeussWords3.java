/*
 * SuessWords3.java
 *
 * gets the fifty unique words in Green Eggs and Ham, and saves them in a file
 *
 * uses a tree implementation
 *
 * --Jack LaManna--
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class SeussWords3
{
	public static String removePunctuation (String s)
	{
		String final_word = "";
		for (int i=0; i < s.length(); i++)
		{
			if (Character.isLetter(s.charAt(i)))
				final_word += s.charAt(i);
		}
		return final_word;
		// to be implemented
	}
	public static void main (String [] args)
	{
		Set<String> words = new TreeSet<>();
		try
		{
			File myObj = new File("greenEggs.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNext())
			{
				String data = myReader.next();
				data = data.toLowerCase();
				data = removePunctuation(data);
				if (!words.contains(data))
					words.add(data);
			}
			myReader.close();
			Iterator<String> iter = words.iterator();
			PrintWriter myWriter = new PrintWriter("words.txt");
			while (iter.hasNext())
			{

				myWriter.write(iter.next());
				myWriter.write("\n");

			}
			myWriter.close();
			// to be implemented
		}

		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
