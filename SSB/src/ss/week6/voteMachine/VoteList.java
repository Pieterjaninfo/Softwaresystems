package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

public class VoteList {
	
	private static Map<String, Integer> votes = new HashMap<String, Integer>();
	
	/**
	 * Add a vote to a given party, returns true if successful, false if not.
	 * @param Party The party that is voted for.
	 * @return
	 */
	public boolean addVote(String party) {
		if (party == null) {
			return false;
		}
		if (votes.containsKey(party)) {
			Integer numberOfVotes = votes.get(party);
			votes.remove(party);
			votes.put(party, numberOfVotes);
			return true;
		}
		votes.put(party, 1);
		return true;
	}
	
	public static Map<String, Integer> getVotes() {
		return votes;
	}
}
