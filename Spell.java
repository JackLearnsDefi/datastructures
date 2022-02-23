import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * Spell.java
 *
 * implements a spell checker
 *
 * --Jack LaManna--
 */

public class Spell
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
		try
		{
			Set<String> dict = new HashSet(143093);
			File myObj = new File("dictionary.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNext())
			{
				String data = myReader.next();
				data = data.toLowerCase();
				data = removePunctuation(data);
				if (!dict.contains(data))
					dict.add(data);
			}
			//System.out.println(dict);
			File myObj2 = new File("test.txt");
			Scanner myReader2 = new Scanner(myObj2);
			PrintWriter myWriter = new PrintWriter("misspelled.txt");
			while (myReader2.hasNext())
			{
				String data2 = myReader2.next();
				data2 = data2.toLowerCase();
				data2 = removePunctuation(data2);
				//System.out.println(data2);
				if (!dict.contains(data2))
					{
						myWriter.write(data2);
						myWriter.write("\n");
						System.out.println(data2);
					}
			}
			myReader2.close();
			myWriter.close();


			// to be implemented
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
