/*
 * simulates a vote in Congress
 *
 * --Jack LaManna--
 */

import java.util.Iterator;

public class Vote
{
	private static int yesVotes = 0;

	private Map<String, String> votes;

	public Vote()
	{
		votes = new TreeMap<>();
	}

	public void addVote(String s)
	{
		String vote = randomVote();
		votes.add(s, vote);
		if (vote == "Yes")
		{
			yesVotes++;
		}



		// get random vote
		// if yes vote, adjust counter
		// add senator and vote
	}

	public String changeVote(String s)
	{
		String vo = getVote(s);
		String orig = vo;
		if (vo == "Yes")
		{
			votes.set(s, "No");
			yesVotes--;
		}
		else
		{
			votes.set(s, "Yes");
			yesVotes ++;
		}
		// get senator's vote
		// switch it
		// adjust yes vote counter accordingly
		// return original vote
		return orig;
	}

	public String randomVote()
	{
		// return random yes or no vote
		int temp = (Math.random() <= 0.5) ? 1 : 2;
		if (temp ==1)
		{
			return "Yes";
		}
		else
			return "No";
	}

	public String getVote(String s)
	{
		return votes.get(s);
	}

	public String toString()
	{
		return votes.toString();
	}

	public int size()
	{
		return votes.size();
	}

	public Iterator<String> iterator()
	{
		return votes.iterator();
	}

	public static int yesVotes()
	{
		return yesVotes;
	}

	public String result()
	{
		return yesVotes*1./size() > .5 ? "passes" : "is not passed";
	}
}
